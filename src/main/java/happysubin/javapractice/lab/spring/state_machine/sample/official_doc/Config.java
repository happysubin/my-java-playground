package happysubin.javapractice.lab.spring.state_machine.sample.official_doc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineModelConfigurer;
import org.springframework.statemachine.config.model.StateMachineModelFactory;
import org.springframework.statemachine.data.*;

@Configuration
@EnableStateMachineFactory
public class Config extends StateMachineConfigurerAdapter<String, String> {

    private final StateRepository<? extends RepositoryState> stateRepository;

    private final TransitionRepository<? extends RepositoryTransition> transitionRepository;

    public Config(StateRepository<? extends RepositoryState> stateRepository,
                  TransitionRepository<? extends RepositoryTransition> transitionRepository) {
        this.stateRepository = stateRepository;
        this.transitionRepository = transitionRepository;
    }

    //
//    @Override
//    public void configure(StateMachineModelConfigurer<String, String> model) throws Exception {
//        model
//                .withModel()
//                .factory(modelFactory());
//    }
//
//    @Bean
//    public StateMachineModelFactory<String, String> modelFactory() {
//        return new RepositoryStateMachineModelFactory(stateRepository, transitionRepository);
//    }
}


