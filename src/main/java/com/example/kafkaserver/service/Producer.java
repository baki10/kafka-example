package com.example.kafkaserver.service;

import com.example.kafkaserver.model.KafkaContainer;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class Producer {

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);

    @Value("${app.topic.example}")
    private String topic;

    private final KafkaTemplate<String, KafkaContainer<?>> kafkaTemplate;

    public <T> void send(T data) {
        logger.info("Sending " + data);
        var kafkaContainer = new KafkaContainer<>(data);
        var message = MessageBuilder
            .withPayload(kafkaContainer)
            .setHeader(KafkaHeaders.TOPIC, topic)
            .build();
        this.kafkaTemplate.send(message);
    }
}
