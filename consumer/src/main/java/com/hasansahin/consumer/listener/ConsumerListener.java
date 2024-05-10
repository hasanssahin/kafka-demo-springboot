package com.hasansahin.consumer.listener;

import com.hasansahin.consumer.dto.User;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerListener.class);

    @KafkaListener(topics = "${kafka.topic}")
    public void consume(ConsumerRecord<String, User> message) {
        LOGGER.info("Message received: {}", message.value());
        User user = message.value();
        LOGGER.info("User: {}", user);
    }
}
