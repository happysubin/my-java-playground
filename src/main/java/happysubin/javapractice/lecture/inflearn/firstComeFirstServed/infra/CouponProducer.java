package happysubin.javapractice.lecture.inflearn.firstComeFirstServed.infra;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class CouponProducer {

    private final KafkaTemplate kafkaTemplate;

    public CouponProducer(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void create(Long userId){
        kafkaTemplate.send("coupon_create", userId);
    }
}
