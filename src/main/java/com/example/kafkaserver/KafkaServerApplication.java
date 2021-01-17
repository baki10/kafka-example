package com.example.kafkaserver;

import com.example.kafkaserver.model.UserDto;
import com.example.kafkaserver.service.Producer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class KafkaServerApplication implements CommandLineRunner {

    private final Producer producer;

    public KafkaServerApplication(Producer producer) {
        this.producer = producer;
    }

    public static void main(String[] args) {
        SpringApplication.run(KafkaServerApplication.class, args);
    }

    @Override
    public void run(String... args) {

        producer.send("One String");
        producer.send(42);
        producer.send(new UserDto("John", 21));
        producer.send(List.of(
                new UserDto("Jack", 23),
                new UserDto("Kate", 19),
                new UserDto("Smith", 26)
        ));
    }
}
