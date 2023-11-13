package happysubin.javapractice.lecture.inflearn.firstComeFirstServed.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
}
