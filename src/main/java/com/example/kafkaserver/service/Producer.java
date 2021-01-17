package com.example.kafkaserver.service;

import com.example.kafkaserver.model.KafkaContainer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class Producer {

    @Value("${app.topic.example}")
    private String topic;

    private final KafkaTemplate<String, KafkaContainer<?>> kafkaTemplate;

    public <T> void send(T data) {
        this.kafkaTemplate.send(MessageBuilder
                .withPayload(new KafkaContainer<>(data))
                .setHeader(KafkaHeaders.TOPIC, topic)
                .build());
        log.info("Sent data: " + data);
    }
}
