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

    private static final Log log = LogFactory.getLog(CustomStateMachineService.class);
    private final StateMachineFactory<S, E> stateMachineFactory;
    private final StateMachinePersist<S, E, String> stateMachinePersist;


    public CustomStateMachineService(StateMachineFactory<S, E> stateMachineFactory, StateMachinePersist<S, E, String> stateMachinePersist) {
        Assert.notNull(stateMachineFactory, "'stateMachineFactory' must be set");
        this.stateMachineFactory = stateMachineFactory;
        this.stateMachinePersist = stateMachinePersist;
    }

    public StateMachine<S, E> acquireStateMachine(String machineId) {
        return this.acquireStateMachine(machineId, true);
    }

    public StateMachine<S, E> acquireStateMachine(String machineId, boolean start) {
        log.info("Acquiring machine with id " + machineId);

        StateMachine stateMachine;
        StateMachineContext stateMachineContext;

        try {
            stateMachineContext = this.stateMachinePersist.read(machineId);

            if(stateMachineContext == null) {
                throw new Exception("안돼");
            }

            stateMachine = this.restoreStateMachine(stateMachineFactory.getStateMachine(machineId), stateMachineContext);

        } catch (Exception var7) {
            log.error("Error handling context", var7);
            throw new StateMachineException("Unable to read context from store", var7);
        }

        return this.handleStart(stateMachine, start);
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


    @Override
    public void destroy() throws Exception {
        //TODO
    }

    @Override
    public void releaseStateMachine(String s) {
        //TODO
    }

    @Override
    public void releaseStateMachine(String s, boolean b) {
        //TODO
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

    public StateMachine saveNewStateMachine(String machineId) {
        StateMachine<S, E> stateMachine = stateMachineFactory.getStateMachine(machineId);
        return this.handleStart(stateMachine, true);
    }
}
