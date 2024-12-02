package happysubin.javapractice.lab.spring.state_machine.order;

import happysubin.javapractice.lab.spring.state_machine.order.action.PlaceOrderAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.StateMachinePersist;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.persist.StateMachineRuntimePersister;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@EnableAsync
@EnableStateMachineFactory
@Configuration
public class OrderStateMachineConfig extends EnumStateMachineConfigurerAdapter<OrderState, OrderEvent> {

    private final StateMachineRuntimePersister stateMachineRuntimePersister;

    private final PlaceOrderAction placeOrderAction;

    @Autowired
    private  PlatformTransactionManager platformTransactionManager;

    public OrderStateMachineConfig(StateMachineRuntimePersister stateMachineRuntimePersister,
                                   PlaceOrderAction placeOrderAction) {
        this.stateMachineRuntimePersister = stateMachineRuntimePersister;
        this.placeOrderAction = placeOrderAction;
    }



    @Override
    public void configure(StateMachineStateConfigurer<OrderState, OrderEvent> states) throws Exception {
        states.withStates()
                .initial(OrderState.NEW)
                .state(OrderState.PROCESSING)
                .state(OrderState.COMPLETED)
                .state(OrderState.CANCELLED)
                .end(OrderState.COMPLETED)
                .end(OrderState.CANCELLED);
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<OrderState, OrderEvent> transitions) throws Exception {
        transitions.withExternal()
                .source(OrderState.NEW).target(OrderState.PROCESSING).event(OrderEvent.PLACE_ORDER)
                .action(placeOrderAction, new Action<>() {
                    @Override
                    public void execute(StateContext<OrderState, OrderEvent> stateContext) {
                        Exception exception = stateContext.getException();
                        System.out.println("exception = " + exception);
                        TransactionStatus txStatus = platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
                        platformTransactionManager.rollback(txStatus);
                    }
                })
                .and().withExternal()
                .source(OrderState.PROCESSING).target(OrderState.COMPLETED).event(OrderEvent.COMPLETE_ORDER)
                .and().withExternal()
                .source(OrderState.NEW).target(OrderState.CANCELLED).event(OrderEvent.CANCEL_ORDER)
                .and().withExternal()
                .source(OrderState.PROCESSING).target(OrderState.CANCELLED).event(OrderEvent.CANCEL_ORDER);
    }


    @Override
    public void configure(StateMachineConfigurationConfigurer<OrderState, OrderEvent> config) throws Exception {
        config
                .withPersistence()
                .runtimePersister(stateMachineRuntimePersister);
    }
}


