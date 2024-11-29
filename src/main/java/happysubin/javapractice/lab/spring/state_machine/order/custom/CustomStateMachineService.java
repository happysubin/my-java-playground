package happysubin.javapractice.lab.spring.state_machine.order.custom;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.Lifecycle;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.StateMachineContext;
import org.springframework.statemachine.StateMachineException;
import org.springframework.statemachine.StateMachinePersist;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.service.DefaultStateMachineService;
import org.springframework.statemachine.service.StateMachineService;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class CustomStateMachineService<S, E> implements StateMachineService<S, E>, DisposableBean {

    private static final Log log = LogFactory.getLog(DefaultStateMachineService.class);
    private final StateMachineFactory<S, E> stateMachineFactory;
    private final Map<String, StateMachine<S, E>> machines;
    private final StateMachinePersist<S, E, String> stateMachinePersist;

    public CustomStateMachineService(StateMachineFactory<S, E> stateMachineFactory) {
        this(stateMachineFactory, (StateMachinePersist)null);
    }

    public CustomStateMachineService(StateMachineFactory<S, E> stateMachineFactory, StateMachinePersist<S, E, String> stateMachinePersist) {
        this.machines = new HashMap();
        Assert.notNull(stateMachineFactory, "'stateMachineFactory' must be set");
        this.stateMachineFactory = stateMachineFactory;
        this.stateMachinePersist = stateMachinePersist;
    }

    public final void destroy() throws Exception {
        this.doStop();
    }

    public StateMachine<S, E> acquireStateMachine(String machineId) {
        return this.acquireStateMachine(machineId, true);
    }

    public StateMachine<S, E> acquireStateMachine(String machineId, boolean start) {
        log.info("Acquiring machine with id " + machineId);
        log.info("Getting new machine  from factory with id " + machineId);
        StateMachine stateMachine = this.stateMachineFactory.getStateMachine(machineId);
        try {
            StateMachineContext<S, E> stateMachineContext = this.stateMachinePersist.read(machineId);
            stateMachine = this.restoreStateMachine(stateMachine, stateMachineContext);
        } catch (Exception var7) {
            log.error("Error handling context", var7);
            throw new StateMachineException("Unable to read context from store", var7);
        }

        this.machines.put(machineId, stateMachine);
        return this.handleStart(stateMachine, start);
    }

    public void releaseStateMachine(String machineId) {
        log.info("Releasing machine with id " + machineId);
        synchronized(this.machines) {
            StateMachine<S, E> stateMachine = (StateMachine)this.machines.remove(machineId);
            if (stateMachine != null) {
                log.info("Found machine with id " + machineId);
                stateMachine.stopReactively().block();
            }

        }
    }

    public void releaseStateMachine(String machineId, boolean stop) {
        log.info("Releasing machine with id " + machineId);
        synchronized(this.machines) {
            StateMachine<S, E> stateMachine = (StateMachine)this.machines.remove(machineId);
            if (stateMachine != null) {
                log.info("Found machine with id " + machineId);
                this.handleStop(stateMachine, stop);
            }

        }
    }

    public boolean hasStateMachine(String machineId) {
        synchronized(this.machines) {
            return this.machines.containsKey(machineId);
        }
    }

    protected void doStop() {
        log.info("Entering stop sequence, stopping all managed machines");
        synchronized(this.machines) {
            ArrayList<String> machineIds = new ArrayList(this.machines.keySet());
            Iterator var3 = machineIds.iterator();

            while(var3.hasNext()) {
                String machineId = (String)var3.next();
                this.releaseStateMachine(machineId, true);
            }

        }
    }

    protected StateMachine<S, E> restoreStateMachine(StateMachine<S, E> stateMachine, StateMachineContext<S, E> stateMachineContext) {
        if (stateMachineContext == null) {
            return stateMachine;
        } else {
            stateMachine.stopReactively().block();
            stateMachine.getStateMachineAccessor().doWithAllRegions((function) -> {
                function.resetStateMachineReactively(stateMachineContext).block();
            });
            return stateMachine;
        }
    }

    protected StateMachine<S, E> handleStart(StateMachine<S, E> stateMachine, boolean start) {
        if (start && !((Lifecycle)stateMachine).isRunning()) {
            StartListener<S, E> listener = new StartListener(stateMachine);
            stateMachine.addStateListener(listener);
            stateMachine.startReactively().block();

            try {
                listener.latch.await();
            } catch (InterruptedException var5) {
            }
        }

        return stateMachine;
    }

    protected StateMachine<S, E> handleStop(StateMachine<S, E> stateMachine, boolean stop) {
        if (stop && ((Lifecycle)stateMachine).isRunning()) {
            StopListener<S, E> listener = new StopListener(stateMachine);
            stateMachine.addStateListener(listener);
            stateMachine.stopReactively().block();

            try {
                listener.latch.await();
            } catch (InterruptedException var5) {
            }
        }

        return stateMachine;
    }

    private static class StartListener<S, E> extends StateMachineListenerAdapter<S, E> {
        final CountDownLatch latch = new CountDownLatch(1);
        final StateMachine<S, E> stateMachine;

        public StartListener(StateMachine<S, E> stateMachine) {
            this.stateMachine = stateMachine;
        }

        public void stateMachineStarted(StateMachine<S, E> stateMachine) {
            this.stateMachine.removeStateListener(this);
            this.latch.countDown();
        }
    }

    private static class StopListener<S, E> extends StateMachineListenerAdapter<S, E> {
        final CountDownLatch latch = new CountDownLatch(1);
        final StateMachine<S, E> stateMachine;

        public StopListener(StateMachine<S, E> stateMachine) {
            this.stateMachine = stateMachine;
        }

        public void stateMachineStopped(StateMachine<S, E> stateMachine) {
            this.stateMachine.removeStateListener(this);
            this.latch.countDown();
        }
    }
}
