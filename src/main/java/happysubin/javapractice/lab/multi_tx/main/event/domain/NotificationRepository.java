package happysubin.javapractice.lab.multi_tx.main.event.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository <Notification, Long> {
}
