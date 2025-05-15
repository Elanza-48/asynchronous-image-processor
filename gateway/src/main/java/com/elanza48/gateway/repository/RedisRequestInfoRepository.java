package com.elanza48.gateway.repository;

import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Repository;

import libs.model.requestInfo.RequestInfo;
import libs.model.requestInfo.RequestStatus;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@Repository
@AllArgsConstructor
public class RedisRequestInfoRepository {
  
  private ReactiveRedisOperations<String, RequestInfo> operations;

  public Mono<Void> updateStatus(String requestId, RequestStatus status) {
    // return operations.opsForValue().set(requestId, )
    return Mono.just(null);
  }  
}
