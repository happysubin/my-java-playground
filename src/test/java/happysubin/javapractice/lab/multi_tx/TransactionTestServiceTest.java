package happysubin.javapractice.lab.multi_tx;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TransactionTestServiceTest {

    @Autowired
    TransactionTestService transactionTestService;

    @Test
    void test1() {
        transactionTestService.execute();
    }
}