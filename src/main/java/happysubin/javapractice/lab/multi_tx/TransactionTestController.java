package happysubin.javapractice.lab.multi_tx;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tx-test")
public class TransactionTestController {

    private final TransactionTestService transactionTestService;

    public TransactionTestController(TransactionTestService transactionTestService) {
        this.transactionTestService = transactionTestService;
    }

    @GetMapping
    public void txTest() {
        transactionTestService.execute();
    }
}
