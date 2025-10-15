package config;
import org.springframework.amqp.core.Declarable;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class RabbitMqConfig {
    public static final String ORDER_CREATED_QUEUE = "btg-pactual-order-created";  // Corrigido o erro de digitação
    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
    @Bean  // Este método agora está dentro da classe
    public Declarable orderCreatedQueue() {  // Corrigido para "orderCreatedQueue"
        return new Queue(ORDER_CREATED_QUEUE);
    }
}
