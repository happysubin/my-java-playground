package happysubin.javapractice.lab.multi_tx.sub;

import happysubin.javapractice.lab.multi_tx.main.Data;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubDataRepository extends JpaRepository<SubData, Long> {
}
