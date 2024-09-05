package happysubin.javapractice.lab.multi_tx.sub;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import static happysubin.javapractice.lab.multi_tx.config.SubDatabaseConfig.SUB_TRANSACTION_MANGER_NAME;

@Component
public class SubDataDomainService {

    private final SubDataRepository subDataRepository;

    public SubDataDomainService(SubDataRepository subDataRepository) {
        this.subDataRepository = subDataRepository;
    }

    @Transactional(transactionManager = SUB_TRANSACTION_MANGER_NAME)
    public void execute() {
        subDataRepository.save(new SubData("sub"));
        throw new RuntimeException("TEST");
    }
}
