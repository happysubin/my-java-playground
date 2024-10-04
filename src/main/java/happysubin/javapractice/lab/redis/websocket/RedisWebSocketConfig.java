package happysubin.javapractice.lab.redis.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class RedisWebSocketConfig implements WebSocketMessageBrokerConfigurer {


    @Override
    public void registerStompEndpoints(StompEndpointRegistry endpointRegistry) {
        endpointRegistry.addEndpoint("/ws/alarm").setAllowedOrigins("*"); //웹소켓 엔드포인트
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry brokerRegistry) {
        // 클라이언트에게 topic으로 시작하는 것에 대한 구독 기능 제공
        //채널 구독을 위해서는 /sub/1 과 같은 형식
        // /ch로 시작하는 "destination" 헤더를 가진 메세지를 브로커로 라우팅
        brokerRegistry.enableSimpleBroker("/ch");


        // pup 경로로 시작하는 STOMP 메세지의 "destination" 헤더는 @Controller 객체의 @MessageMapping 메서드로 라우팅
        brokerRegistry.setApplicationDestinationPrefixes("/topic");
    }
}