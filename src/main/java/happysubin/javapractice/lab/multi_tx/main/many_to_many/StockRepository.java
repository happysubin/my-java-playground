package happysubin.javapractice.lab.multi_tx.main.many_to_many;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
}
