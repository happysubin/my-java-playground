package happysubin.javapractice.lab.multi_tx;


import happysubin.javapractice.lab.multi_tx.main.MainDataDomainService;
import happysubin.javapractice.lab.multi_tx.sub.SubDataDomainService;
import org.aspectj.apache.bcel.classfile.annotation.RuntimeInvisAnnos;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionTestService {

    private final MainDataDomainService mainDataDomainService;
    private final SubDataDomainService subDataDomainService;

    public TransactionTestService(MainDataDomainService mainDataDomainService, SubDataDomainService subDataDomainService) {
        this.mainDataDomainService = mainDataDomainService;
        this.subDataDomainService = subDataDomainService;
    }

    @Transactional
    public void execute() {
        mainDataDomainService.execute();
        subDataDomainService.execute();
    }
}
