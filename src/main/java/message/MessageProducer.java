package message;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.amqp.core.Queue;




@Service
public class MessageProducer {

    private final RabbitTemplate rabbitTemplate;
    private final Queue queue;

    @Autowired
    public MessageProducer(RabbitTemplate rabbitTemplate, Queue queue) {
        this.rabbitTemplate = rabbitTemplate;
        this.queue = queue;
    }

    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend(queue.getName(), message);
    }

}
