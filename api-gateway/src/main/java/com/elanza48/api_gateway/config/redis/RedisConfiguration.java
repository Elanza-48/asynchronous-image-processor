package com.elanza48.api_gateway.config.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import libs.model.requestInfo.RequestInfo;
import libs.model.webhookInfo.WebhookInfo;

@Configuration
public class RedisConfiguration {
  
  @Bean
  ReactiveRedisOperations<String, RequestInfo> redisOperationsReuqestInfo(ReactiveRedisConnectionFactory factory) {
    
    Jackson2JsonRedisSerializer<RequestInfo> serializer = new Jackson2JsonRedisSerializer<>(RequestInfo.class);
    RedisSerializationContext.RedisSerializationContextBuilder<String, RequestInfo> builder = RedisSerializationContext
      .newSerializationContext(new StringRedisSerializer());

    RedisSerializationContext<String, RequestInfo> context = builder.value(serializer).build();
    return new ReactiveRedisTemplate<>(factory, context);
  }

  @Bean
  ReactiveRedisOperations<String, WebhookInfo> redisOperationsWebhookInfo(ReactiveRedisConnectionFactory factory) {
    
    Jackson2JsonRedisSerializer<WebhookInfo> serializer = new Jackson2JsonRedisSerializer<>(WebhookInfo.class);
    RedisSerializationContext.RedisSerializationContextBuilder<String, WebhookInfo> builder = RedisSerializationContext
      .newSerializationContext(new StringRedisSerializer());

    RedisSerializationContext<String, WebhookInfo> context = builder.value(serializer).build();
    return new ReactiveRedisTemplate<>(factory, context);
  }
}
