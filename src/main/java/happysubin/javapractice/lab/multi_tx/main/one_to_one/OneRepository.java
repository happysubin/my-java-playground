package happysubin.javapractice.lab.multi_tx.main.one_to_one;

import org.springframework.data.jpa.repository.JpaRepository;


public interface OneRepository extends JpaRepository <One, Long> {
}