package com.example.kafkaserver.service;

import com.example.kafkaserver.model.KafkaContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    private final Logger logger = LoggerFactory.getLogger(Producer.class);

    @KafkaListener(topics = "${app.topic.example}")
    public void receiveData(KafkaContainer<?> kafkaContainer) {
        logger.info("received container='{}'", kafkaContainer);
    }
}
