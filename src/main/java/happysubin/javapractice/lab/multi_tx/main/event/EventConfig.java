package happysubin.javapractice.lab.multi_tx.main.event;


import jakarta.annotation.PostConstruct;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventConfig {

    private final ApplicationContext applicationContext;

    public EventConfig(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @PostConstruct
    public void eventsInitializer(){
        Events.setPublisher(applicationContext);
    }
}
