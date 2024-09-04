package happysubin.javapractice.lab.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.concurrent.CompletableFuture;

@Component
public class AsyncEventListener {

    private final AsyncEventService eventService;

    private Logger log = LoggerFactory.getLogger(getClass());


    public AsyncEventListener(AsyncEventService eventService) {
        this.eventService = eventService;
    }

    // AsyncConfig에서 AsyncUncaughtExceptionHandler를 설정하지 않으면 이건 오류가 잡히지 않음
    //AsyncConfig에서 AsyncUncaughtExceptionHandler를 설정함. void 타입인 경우 해당 객체에서 예외 처리함.
    @Async
    @TransactionalEventListener(AsyncEvent.class)
    void handler(AsyncEvent event) {
        System.out.println(Thread.currentThread().getName()); //다른 스레드가 뜬다.
        System.out.println(event);
        throw new RuntimeException("help me");
    }

    @Async
    @TransactionalEventListener(AsyncEvent.class)
    CompletableFuture handler2(AsyncEvent event) {
        return CompletableFuture
                .runAsync(() -> {
                    System.out.println("event = " + event);
                    throw new RuntimeException("exception");
                })
                .exceptionally(fn -> {
                    log.error(fn.getMessage());
                    return null; //원래는 대체 결과를 반환해야함.
                });
    }
}
