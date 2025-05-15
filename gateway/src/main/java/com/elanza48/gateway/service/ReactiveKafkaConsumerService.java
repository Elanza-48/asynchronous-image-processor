package com.elanza48.gateway.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.reactive.ReactiveKafkaConsumerTemplate;
import org.springframework.stereotype.Service;

import com.elanza48.gateway.config.kafka.ReactiveKafkaConsumerConfig;
import com.elanza48.gateway.model.AuthenticationModel;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ReactiveKafkaConsumerService {

  private ReactiveKafkaConsumerTemplate<String, AuthenticationModel> consumerTemplate;
    
  @Autowired
  public void UserEventService(ReactiveKafkaConsumerConfig<String, AuthenticationModel> consumerConfig) {
    this.consumerTemplate = consumerConfig.createConsumerTemplate(AuthenticationModel.class, "user-events-topic");
  }
  

}
