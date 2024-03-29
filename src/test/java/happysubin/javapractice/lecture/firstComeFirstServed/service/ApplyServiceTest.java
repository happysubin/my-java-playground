package happysubin.javapractice.lecture.firstComeFirstServed.service;

import happysubin.javapractice.lecture.inflearn.firstComeFirstServed.domain.CouponRepository;
import happysubin.javapractice.lecture.inflearn.firstComeFirstServed.service.ApplyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class ApplyServiceTest {

    @Autowired
    ApplyService applyService;


    @Autowired
    CouponRepository couponRepository;


    @Test
    public void 한번만응모() {
        applyService.apply(1L);

        long count = couponRepository.count();

        assertThat(count).isEqualTo(1);
    }

    @Test
    public void 여러명응모() throws InterruptedException {
        int threadCount = 1000;
        ExecutorService executorService = Executors.newFixedThreadPool(32);
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; i++) {
            long userId = i;
            executorService.submit(() -> {
                try {
                    applyService.apply(userId);
                } finally {
                    countDownLatch.countDown();
                }

            });
        }

        countDownLatch.await();

        long count = couponRepository.count();

        assertThat(count).isEqualTo(100); //마찬가지로 경쟁 조건이 발생, 레디스를 사용해 해결
    }
}