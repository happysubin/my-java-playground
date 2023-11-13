package happysubin.javapractice.lecture.inflearn.concurrency.facade;

import happysubin.javapractice.lecture.inflearn.concurrency.service.OptimisticLockStockService;
import org.springframework.stereotype.Service;

/**
 * 실패했을 때 재시도를 하기 위함이다.
 */

@Service
public class OptimisticLockStockFacade {

    private OptimisticLockStockService optimisticLockStockService;

    public OptimisticLockStockFacade(OptimisticLockStockService optimisticLockStockService) {
        this.optimisticLockStockService = optimisticLockStockService;
    }

    public void decrease(Long id, Long quantity) throws InterruptedException {
        while (true) {
            try {
                optimisticLockStockService.decrease(id, quantity);
                break;
            } catch (Exception e) {
                Thread.sleep(50);
            }
        }
    }
}