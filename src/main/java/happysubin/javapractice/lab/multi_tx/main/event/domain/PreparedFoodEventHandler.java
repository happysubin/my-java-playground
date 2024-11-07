package happysubin.javapractice.lab.multi_tx.main.event.domain;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Component
public class PreparedFoodEventHandler {

    private final NotificationRepository notificationRepository;

    public PreparedFoodEventHandler(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }



    @EventListener(PreparedFoodEvent.class)
    public void handle(PreparedFoodEvent event){
        if(event != null){
            System.out.println("TransactionSynchronizationManager.isActualTransactionActive() = " + TransactionSynchronizationManager.isActualTransactionActive());
            notificationRepository.save(new Notification(event.getFoodId(), "content " + event.getFoodId()));
        }
    }
}
