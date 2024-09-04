package happysubin.javapractice.lecture.inflearn.firstComeFirstServed.domain;

import jakarta.persistence.*;


@Entity
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    public Coupon() {}

    public Coupon(Long userId) {
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }
}
