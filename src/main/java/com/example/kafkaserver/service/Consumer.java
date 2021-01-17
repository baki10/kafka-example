package com.example.kafkaserver.service;

import com.example.kafkaserver.model.KafkaContainer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Consumer {

    @KafkaListener(topics = "${app.topic.example}")
    public void receiveData(KafkaContainer<?> kafkaContainer) {
        log.info("received data='{}'", kafkaContainer.getData());
    }
}
