package happysubin.javapractice.lab.multi_tx;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TransactionTestServiceTest {

    @Autowired
    TransactionTestService transactionTestService;

//    @Transactional sub는 롤백되지 않음
    //@Rollback 둘다 롤백 안됨
    @Test
    void test1() {
        transactionTestService.execute();
    }
}