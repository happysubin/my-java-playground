package happysubin.javapractice.lab.spring.state_machine.sample.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateMachinePersist;
import org.springframework.statemachine.data.RepositoryStateMachine;
import org.springframework.statemachine.data.jpa.JpaRepositoryStateMachinePersist;
import org.springframework.statemachine.data.jpa.JpaStateMachineRepository;
import org.springframework.statemachine.persist.DefaultStateMachinePersister;
import org.springframework.statemachine.persist.StateMachinePersister;

@Configuration
public class StateMachinePersisterConfig {


    private JpaStateMachineRepository repository;

    public StateMachinePersisterConfig(JpaStateMachineRepository repository) {
        this.repository = repository;
    }

    @Bean
    public StateMachinePersist JpaRepositoryStateMachinePersist(){
        return new JpaRepositoryStateMachinePersist(repository);
    }

    @Bean
    public StateMachinePersister<OrderState, OrderEvent, Long> stateMachinePersister() {
        return new DefaultStateMachinePersister<>(JpaRepositoryStateMachinePersist());
    }
}
