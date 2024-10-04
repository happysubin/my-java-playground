package happysubin.javapractice.lab.redis.websocket;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.redisson.client.protocol.decoder.ObjectMapDecoder;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.Topic;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class RedisWebsocketController {

    private AtomicInteger i = new AtomicInteger();
    private final MessageListenerAdapter messageListenerAdapter;

    private final RedisMessageListenerContainer redisMessageListenerContainer;

    private final StringRedisTemplate stringRedisTemplate;

    private final ObjectMapper objectMapper;


    public RedisWebsocketController(MessageListenerAdapter messageListenerAdapter,
                                    RedisMessageListenerContainer redisMessageListenerContainer,
                                    StringRedisTemplate stringRedisTemplate,
                                    ObjectMapper objectMapper) {
        this.messageListenerAdapter = messageListenerAdapter;
        this.redisMessageListenerContainer = redisMessageListenerContainer;
        this.stringRedisTemplate = stringRedisTemplate;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/add")
    public String  add() throws JsonProcessingException {
//        int result = i.addAndGet(1);
        int result = 1;

        Topic topic = new ChannelTopic("/ch/" + result);
        redisMessageListenerContainer.addMessageListener(messageListenerAdapter, topic);
        stringRedisTemplate.convertAndSend("/ch/" + result, objectMapper.writeValueAsString(new Data(result, "결과: " + result)));
        return String.valueOf(result);
    }
}
