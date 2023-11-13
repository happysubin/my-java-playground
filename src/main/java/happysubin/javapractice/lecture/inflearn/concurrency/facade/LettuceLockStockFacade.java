package happysubin.javapractice.lecture.inflearn.concurrency.facade;

import happysubin.javapractice.lecture.inflearn.concurrency.domain.RedisLockRepository;
import happysubin.javapractice.lecture.inflearn.concurrency.service.StockService;
import org.springframework.stereotype.Component;

/**
 * NamedLock과 비슷하다.
 * 구현이 쉽다는 장점이 있다.
 * spin-lock이므로 레디스의 부하가 있을 수 있다.
 */

@Component
public class LettuceLockStockFacade {

    private RedisLockRepository redisLockRepository;

    private StockService stockService;

    public LettuceLockStockFacade(RedisLockRepository redisLockRepository, StockService stockService) {
        this.redisLockRepository = redisLockRepository;
        this.stockService = stockService;
    }

    public void decrease(Long key, Long quantity) throws InterruptedException {
        while (!redisLockRepository.lock(key)) { //lock 획득을 시도
            Thread.sleep(100); //실패한다면 sleep
        }

        try {
            //lock을 성공한다면
            stockService.decrease(key, quantity);
        } finally {
            redisLockRepository.unlock(key);
        }
    }
}
