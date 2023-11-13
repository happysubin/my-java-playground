package happysubin.javapractice.lecture.concurrency.facade;

import happysubin.javapractice.lecture.inflearn.concurrency.domain.Stock;
import happysubin.javapractice.lecture.inflearn.concurrency.domain.StockRepository;
import happysubin.javapractice.lecture.inflearn.concurrency.facade.LettuceLockStockFacade;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootTest
class LettuceLockStockFacadeTest {

    @Autowired
    LettuceLockStockFacade stockService;

    @Autowired
    StockRepository stockRepository;

    Stock stock = null;

    @BeforeEach
    void beforeEach(){
        stock = stockRepository.save(new Stock(1L, 100L));
    }

    @AfterEach
    void afterEach(){
        stockRepository.deleteAll();
    }

    @Test
    public void 동시에_100개의_요청() throws InterruptedException {
        int threadCount = 100;
        ExecutorService executorService = Executors.newFixedThreadPool(32);
        CountDownLatch latch = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; i++) {
            executorService.submit(() -> {
                try {
                    stockService.decrease(stock.getId(), 1L);
                } catch (InterruptedException e) {

                } finally {
                    latch.countDown();
                }
            });
        }

        latch.await(); //대기

        stock = stockRepository.findById(stock.getId()).orElseThrow();

        Assertions.assertThat(stock.getQuantity()).isEqualTo(0); //기대하는 값인 0이 나오지 않는다. 경쟁 조건이 발생했기 때문!!!
    }
}