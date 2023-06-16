package happysubin.javapractice.lecture.concurrency.facade;

import happysubin.javapractice.lecture.concurrency.domain.LockRepository;
import happysubin.javapractice.lecture.concurrency.service.StockService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 분산락에서 보통 사용한다.
 * TimeOut을 구현하기도 쉽다.
 * 정합성을 맞출 때도 좋음.
 *
 * 트랜잭션 락 관리와 세션 관리에 주의를 해야함.
 * 실제 사용시에는 구현이 복잡할 가능성이 높다.
 */

@Service
public class NamedLockStockFacade {

    private LockRepository lockRepository;
    private StockService stockService;

    public NamedLockStockFacade(LockRepository lockRepository, StockService stockService) {
        this.lockRepository = lockRepository;
        this.stockService = stockService;
    }

    @Transactional
    public void decrease(Long id, Long quantity) {
        try {
            lockRepository.getLock(id.toString());
            stockService.decrease(id, quantity);
        } finally {
            lockRepository.releaseLock(id.toString());
        }
    }
}
