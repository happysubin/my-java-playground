package happysubin.javapractice.lab.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@EnableAsync
@Configuration(proxyBeanMethods = false)
public class AsyncConfig implements AsyncConfigurer {

    private final AsyncExceptionHandler handler;

    private Logger log = LoggerFactory.getLogger(getClass());

    public AsyncConfig(AsyncExceptionHandler handler) {
        this.handler = handler;
    }

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(21);
        executor.setMaxPoolSize(21);
        executor.setQueueCapacity(50);
        executor.setThreadNamePrefix("MyExecutor-");
        executor.initialize();
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return (ex, method, params) -> {
            System.out.println(ex.getMessage());
            log.error(ex.getMessage() + " " + ex.getClass());
        };
    }

}
