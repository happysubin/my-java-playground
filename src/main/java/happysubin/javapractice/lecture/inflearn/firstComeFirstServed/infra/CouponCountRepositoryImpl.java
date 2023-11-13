package happysubin.javapractice.lecture.inflearn.firstComeFirstServed.infra;

import happysubin.javapractice.lecture.inflearn.firstComeFirstServed.domain.CouponCountRepository;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CouponCountRepositoryImpl implements CouponCountRepository {

    private final RedisTemplate<String, String> redisTemplate;

    public CouponCountRepositoryImpl(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public Long increment(){
        return redisTemplate
                .opsForValue()
                .increment("coupon_count");
    }
}
