package listener;


import dto.OderCreatedEventDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import static config.RabbitMqConfig.ORDER_CREATED_QUEUE;

@Component
public class OderCreatedListener {

    @RabbitListener (queues = ORDER_CREATED_QUEUE)
    public void listen (Message<OderCreatedEventDto> message){

    }
}
