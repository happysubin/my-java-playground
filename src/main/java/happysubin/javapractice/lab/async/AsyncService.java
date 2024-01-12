package happysubin.javapractice.lab.async;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

import javax.transaction.Transactional;

@Service
public class AsyncService {
    private final ApplicationEventPublisher applicationEventPublisher;
    private final DataRepository dataRepository;

    public AsyncService(ApplicationEventPublisher applicationEventPublisher, DataRepository dataRepository) {
        this.applicationEventPublisher = applicationEventPublisher;
        this.dataRepository = dataRepository;
    }

    @Transactional
    public void asyncTest() {
        Data data = new Data("Hello Async World");
        dataRepository.save(data);
        applicationEventPublisher.publishEvent(new AsyncEvent(data));
    }


}
