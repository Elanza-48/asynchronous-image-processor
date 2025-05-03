package com.elanza48.api_gateway.config.kafka;

import java.util.List;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.reactive.ReactiveKafkaConsumerTemplate;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.stereotype.Component;


import lombok.RequiredArgsConstructor;
import reactor.kafka.receiver.ReceiverOptions;

@Component
@EnableKafka
@RequiredArgsConstructor
public class ReactiveKafkaConsumerConfig<K, V> {

  private final KafkaProperties kafkaProperties;

  private ReceiverOptions<K, V> createConsumerOptions(Class<V> clazz, String topic) {
    var options = ReceiverOptions.<K, V>create(this.kafkaProperties.buildConsumerProperties());
    options.consumerProperty(JsonDeserializer.VALUE_DEFAULT_TYPE, clazz.getName());

    options.subscription(List.of(topic));
    return options;
  }

  public ReactiveKafkaConsumerTemplate<K, V> createConsumerTemplate(Class<V> clazz, String topic) {
    return new ReactiveKafkaConsumerTemplate<>(this.createConsumerOptions(clazz, topic));
  }
}
