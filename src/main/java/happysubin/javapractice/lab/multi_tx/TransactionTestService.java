package happysubin.javapractice.lab.multi_tx;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionTestService {

    @Transactional
    public void execute() {

    }
}
