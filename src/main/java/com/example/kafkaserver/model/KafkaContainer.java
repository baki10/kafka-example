package com.example.kafkaserver.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class KafkaContainer<T> {

    private String id;
    private T data;

    public KafkaContainer(T data) {
        this.id = UUID.randomUUID().toString();
        this.data = data;
    }
}
