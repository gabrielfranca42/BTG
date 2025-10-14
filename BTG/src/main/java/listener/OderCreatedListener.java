package listener;


import dto.OderCreatedEventDto;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

import static config.RabbitMqConfig.ORDER_CREATED_QUEUE;

@Component
public class OderCreatedListener {

    private final Logger logger = (Logger) LoggerFactory.getLogger(OderCreatedListener.class);

    @RabbitListener (queues = ORDER_CREATED_QUEUE)
    public void listen (Message<OderCreatedEventDto> message){
        logger.info("message consume: {}");

    }
}
