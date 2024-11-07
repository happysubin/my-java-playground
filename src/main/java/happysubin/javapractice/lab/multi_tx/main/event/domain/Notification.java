package happysubin.javapractice.lab.multi_tx.main.event.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long foodId;
    private String content;

    protected Notification() {}

    public Notification(Long foodId, String content) {
        this.foodId = foodId;
        this.content = content;
    }

    public Long getId() {
        return id;
    }
}
