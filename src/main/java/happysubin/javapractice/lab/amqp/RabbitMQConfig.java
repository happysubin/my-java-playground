package happysubin.javapractice.lab.amqp;

//import org.springframework.amqp.core.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {

    @Autowired
    //AmqpAdmin admin;

//    @PostConstruct
//    void directExchange(){
//
//        DirectExchange exchange = new DirectExchange("direct-exchange");
//        admin.declareExchange(exchange);
//
//        Stack queue = new Stack("test", false);
//        admin.declareQueue(queue);
//
//        Binding binding = BindingBuilder
//                .bind(queue)
//                .to(exchange)
//                .with("members.1");
//
//        admin.declareBinding(binding);
//    }

    @PostConstruct
    void fanOutExchange(){

//        FanoutExchange exchange = new FanoutExchange("fanout-exchange");
//        admin.declareExchange(exchange);
//
//        Queue queue1 = new Queue("test-fan1", false);
//        Queue queue2 = new Queue("test-fan2", false);
//
//        admin.declareQueue(queue1);
//        admin.declareQueue(queue2);
//
//
//        Binding binding1 = BindingBuilder
//                .bind(queue1)
//                .to(exchange);
//
//        Binding binding2 = BindingBuilder
//                .bind(queue2)
//                .to(exchange);
//
//        admin.declareBinding(binding1);
//        admin.declareBinding(binding2);
    }
}
