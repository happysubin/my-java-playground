package happysubin.javapractice.lab.multi_tx.main.event.domain;


import happysubin.javapractice.lab.multi_tx.main.event.Events;
import jakarta.persistence.*;

@Entity
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Food(String name) {
        this.name = name;
    }

    protected Food() {}

    public Long getId() {
        return id;
    }

    public void prepared() {
        Events.raise(new PreparedFoodEvent(id));
    }
}
