package com.elanza48.gateway.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReactiveKafkaProducerService {

  @Autowired
  private final ReactiveKafkaProducerTemplate<String, Object> producerTemplate;

  public void send() {
    
  }
  
}
