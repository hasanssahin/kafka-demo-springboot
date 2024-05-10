package com.hasansahin.producer.service;

import com.hasansahin.producer.dto.User;
import com.hasansahin.producer.publish.Producer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    private final Producer producer;

    public UserService(Producer producer) {
        this.producer = producer;
    }

    public void healthCheck(String message) {
        producer.sendMessage(message);
        LOGGER.info("Message is sent to kafka: {}", message);
    }

    public User sendUserMessage(User user) {
        producer.sendMessage(user);
        LOGGER.info("User is sent to kafka: {}", user);
        return user;
    }

}
