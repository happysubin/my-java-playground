package happysubin.javapractice.lecture.inflearn.concurrency.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LockRepository extends JpaRepository<Stock, Long> {

    @Query(value = "select get_lock(:key, 3000)", nativeQuery = true)
    void getLock(String key);

    @Query(value = "select release_lock(:key)", nativeQuery = true)
    void releaseLock(String key);
}

/**
 * 실제로 NamedLock을 쓰면 DataSource를 분리해야함.
 * 커넥션이 부족해질 수가 있기 때문.
 */