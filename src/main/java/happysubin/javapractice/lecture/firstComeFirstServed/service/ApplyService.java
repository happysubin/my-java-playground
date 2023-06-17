package happysubin.javapractice.lecture.firstComeFirstServed.service;

import happysubin.javapractice.lecture.firstComeFirstServed.domain.Coupon;
import happysubin.javapractice.lecture.firstComeFirstServed.domain.CouponCountRepository;
import happysubin.javapractice.lecture.firstComeFirstServed.domain.CouponRepository;
import org.springframework.stereotype.Service;

@Service
public class ApplyService {

    private final CouponRepository couponRepository;
    private final CouponCountRepository couponCountRepository;

    public ApplyService(CouponRepository couponRepository, CouponCountRepository couponCountRepository) {
        this.couponRepository = couponRepository;
        this.couponCountRepository = couponCountRepository;
    }

    /**
     * lock을 걸어버리면 조회부터 생성까지 모두 lock을 걸어야함.
     * 우리는 쿠폰의 개수에 대한 정합성에만 관심이 있다.
     * redis의 incr을 활용. 키에 대한 밸류를 1씩 증가시킨다. 레디스는 싱글 스레드이므로 동시성도 x, 성능도 좋다
     */
    public void apply(Long userId){
        //long count = couponRepository.count(); //여기서 문제가 발생
        Long count = couponCountRepository.increment();

        if(count > 100 ){
            return ;
        }
        couponRepository.save(new Coupon(userId));
    }
}
