package happysubin.javapractice.lecture.concurrency.facade;

import happysubin.javapractice.lecture.concurrency.service.StockService;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * pub,sub 기반 레디스의 부하를 줄여줌.
 * 별도의 라이브러리를 사용하고, 코드를 직접 작성해야함.
 */

@Component
public class RedissonLockStockFacade {

    private RedissonClient redissonClient;

    private StockService stockService;

    public RedissonLockStockFacade(RedissonClient redissonClient, StockService stockService) {
        this.redissonClient = redissonClient;
        this.stockService = stockService;
    }

    public void decrease(Long key, Long quantity) {
        RLock lock = redissonClient.getLock(key.toString());

        try {
            //몇초를 기다리고, 몇초를 점유할건지 정한다. lock 획득을 시도
            boolean available = lock.tryLock(10, 1, TimeUnit.SECONDS);

            //lock 실패
            if (!available) {
                System.out.println("lock 획득 실패");
                return;
            }

            //lock 성공
            stockService.decrease(key, quantity);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            //lock 해제
            lock.unlock();
        }
    }
}

/**
 * 재시도가 필요하지 않은 lock은 lettuce 활용
 * 재시도가 필요한 lock는 redisson 활용
 *
 * 성능은 redis를 활요한 것이 Mysql 활용보다 좋다. 구축 비용이 있을 뿐.
 */