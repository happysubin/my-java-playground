package happysubin.javapractice.lab.jpa.many_to_many;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionRepository extends JpaRepository<Option, Long> {
}
