package com.elanza48.api_gateway.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.RequestMethod;


@RestController
@RequestMapping("/")
public class WelcomeController {
  
  @RequestMapping(value="/welcome", method=RequestMethod.GET)
  public Mono<ResponseEntity<Map<String, String>>> requestMethodName() {
    Map<String, String> res = new HashMap<>();
    res.put("message", "Hi there !");
    return Mono.just(ResponseEntity.ok().body(res));
  }
}
