package happysubin.javapractice.lab.multi_tx.main;

import happysubin.javapractice.lab.multi_tx.main.Data;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataRepository extends JpaRepository<Data, Long> {
}
