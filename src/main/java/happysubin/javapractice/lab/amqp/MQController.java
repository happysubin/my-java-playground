package happysubin.javapractice.lab.amqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MQController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @GetMapping
    public String test(){
        rabbitTemplate.convertAndSend("direct-exchange", "members.1", "123123");
        return "hello";
    }

    @GetMapping("fan")
    public String testFan(){
        rabbitTemplate.convertAndSend("fan", "members.1", "123123");
        return "hello";
    }
}
