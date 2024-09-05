package happysubin.javapractice.lab.async;

import happysubin.javapractice.lab.multi_tx.main.Data;
import happysubin.javapractice.lab.multi_tx.main.DataRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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
