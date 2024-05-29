package happysubin.javapractice.lab.jpa.many_to_many;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantity;

    public Stock(Integer quantity) {
        this.quantity = quantity;
    }

    public Stock(Long id, Integer quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    protected Stock() {}

    public Long getId() {
        return id;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
