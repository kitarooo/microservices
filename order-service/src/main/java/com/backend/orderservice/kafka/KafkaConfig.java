package com.backend.orderservice.kafka;

import com.backend.orderservice.event.OrderCreateEvent;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class KafkaConfig {


    private final Environment environment;

    Map<String, Object> producerConfig(){
        Map<String, Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                environment.getProperty("spring.kafka.producer.bootstrap-servers"));
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                environment.getProperty("spring.kafka.producer.key-serializer"));
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, environment
                .getProperty("spring.kafka.producer.value-serializer"));
        config.put(ProducerConfig.ACKS_CONFIG, environment.getProperty("spring.kafka.producer.acks"));

        return config;
    }

    @Bean
    ProducerFactory<String, OrderCreateEvent> producerFactory(){
        return new DefaultKafkaProducerFactory<>(producerConfig());
    }

    @Bean
    KafkaTemplate<String, OrderCreateEvent> kafkaTemplate(){
        return new KafkaTemplate<String, OrderCreateEvent>(producerFactory());
    }

    @Bean
    NewTopic createTopic(){
        return TopicBuilder.name("payment-created-event-topic")
                .partitions(3)
                .replicas(3)
                .configs(Map.of("min.insync.replicas", "2"))
                .build();
    }
}
