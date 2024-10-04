package happysubin.javapractice.lab.redis.websocket;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Component;


@Component
public class RedisSubscriber implements MessageListener {

        private final StringRedisTemplate redisTemplate;
        private final ObjectMapper objectMapper;
        private final SimpMessageSendingOperations sendingOperations;


    public RedisSubscriber(StringRedisTemplate redisTemplate, ObjectMapper objectMapper, SimpMessageSendingOperations sendingOperations) {
        this.redisTemplate = redisTemplate;
        this.objectMapper = objectMapper;
        this.sendingOperations = sendingOperations;
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        try {
            String publishMessage = redisTemplate.getStringSerializer().deserialize(message.getBody());
            Data data = objectMapper.readValue(publishMessage, Data.class);

            System.out.println(data.getId());
            sendingOperations.convertAndSend("/ch/" +  data.getId(), data.getContent());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
