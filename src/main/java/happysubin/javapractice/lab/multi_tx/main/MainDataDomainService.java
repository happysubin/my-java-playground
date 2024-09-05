package happysubin.javapractice.lab.multi_tx.main;


import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class MainDataDomainService {

    private final DataRepository dataRepository;

    public MainDataDomainService(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @Transactional
    public void execute() {
        dataRepository.save(new Data("main"));
    }
}
