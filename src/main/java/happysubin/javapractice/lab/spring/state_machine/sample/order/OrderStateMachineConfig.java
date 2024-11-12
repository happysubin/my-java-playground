package happysubin.javapractice.lab.spring.state_machine.sample.order;

import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.data.*;

@EnableStateMachine
@Configuration
public class OrderStateMachineConfig extends EnumStateMachineConfigurerAdapter<OrderState, OrderEvent> {

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
                .and().withExternal()
                .source(OrderState.PROCESSING).target(OrderState.COMPLETED).event(OrderEvent.COMPLETE_ORDER)
                .and().withExternal()
                .source(OrderState.NEW).target(OrderState.CANCELLED).event(OrderEvent.CANCEL_ORDER)
                .and().withExternal()
                .source(OrderState.PROCESSING).target(OrderState.CANCELLED).event(OrderEvent.CANCEL_ORDER);
    }

}


