package happysubin.javapractice.lab.spring.state_machine.order;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.statemachine.data.jpa.JpaPersistingStateMachineInterceptor;
import org.springframework.statemachine.data.jpa.JpaStateMachineRepository;
import org.springframework.statemachine.persist.StateMachineRuntimePersister;
import org.springframework.statemachine.service.DefaultStateMachineService;
import org.springframework.statemachine.service.StateMachineService;

@Configuration
public class StateMachineConfig {

    @Bean
    public StateMachineRuntimePersister<OrderState, OrderEvent, String> stateMachineRuntimePersister (
            JpaStateMachineRepository jpaStateMachineRepository
    ) {
        return new JpaPersistingStateMachineInterceptor<>(jpaStateMachineRepository);
    }

    @Bean
    public StateMachineService<OrderState, OrderEvent> stateMachineService (
            StateMachineFactory<OrderState, OrderEvent> stateMachineFactory,
            StateMachineRuntimePersister<OrderState, OrderEvent, String> stateMachineRuntimePersister
    ) {
        return new DefaultStateMachineService(stateMachineFactory, stateMachineRuntimePersister);
    }
}


