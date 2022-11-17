package dev.jesus.projects.lukaza.payment.config;

import dev.jesus.projects.lukaza.payment.event.delta.OrderStatusEventDelta;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.listener.adapter.RecordFilterStrategy;

import static dev.jesus.projects.lukaza.payment.enums.OrderState.CANCELED;

@Configuration
public class KafkaFilter {

    @Bean("OrderStateFilter")
    public RecordFilterStrategy<String, OrderStatusEventDelta> orderStateFilter(){
        return consumerRecord -> !CANCELED.equals(consumerRecord.value().state());
    }

}
