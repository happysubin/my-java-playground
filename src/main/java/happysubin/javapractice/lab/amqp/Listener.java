package happysubin.javapractice.lab.amqp;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Listener {

    @RabbitListener(queues = "test")
    public void processMessage(String content) {
        System.out.println(content);
    }

    @RabbitListener(queues = "test-fan1")
    public void test1(String content) {
        System.out.println("fan1");
        System.out.println(content);
    }

    @RabbitListener(queues = "test-fan2")
    public void test2(String content) {
        System.out.println("fan2");
        System.out.println(content);
    }
}
