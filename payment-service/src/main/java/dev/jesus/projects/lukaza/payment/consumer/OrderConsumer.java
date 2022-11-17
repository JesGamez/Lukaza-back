package dev.jesus.projects.lukaza.payment.consumer;

import dev.jesus.projects.lukaza.payment.event.delta.OrderStatusEventDelta;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import static dev.jesus.projects.lukaza.payment.config.TopicRegister.ORDER_STATE;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderConsumer {

    @KafkaListener(topics = {ORDER_STATE}, filter = "OrderStateFilter" )
    public void listenOrderState(ConsumerRecord<String,OrderStatusEventDelta> consumerRecord){
        log.info("HOLI: {}", consumerRecord.value());
    }
}
