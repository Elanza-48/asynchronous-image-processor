package com.elanza48.gateway.config.kafka;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate;
import lombok.RequiredArgsConstructor;
import reactor.kafka.sender.SenderOptions;

@Configuration
@EnableKafka
@RequiredArgsConstructor
public class ReactiveKafkaProducerConfig {

  private final KafkaProperties kafkaProperties;

  @Bean
  public <K, V> SenderOptions<K, V> createProducerOptions() {
    return SenderOptions.<K, V>create(this.kafkaProperties.buildProducerProperties());
  }
  
  @Bean
  public <K, V> ReactiveKafkaProducerTemplate<K, V> createProducerTemplate(SenderOptions<K, V> options) {
    return new ReactiveKafkaProducerTemplate<>(options);
  }
}
