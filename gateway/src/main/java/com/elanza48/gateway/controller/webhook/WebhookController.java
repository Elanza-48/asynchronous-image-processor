package com.elanza48.gateway.controller.webhook;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/webhook")
public class WebhookController {

  @RequestMapping(value="/register", method=RequestMethod.POST)
  public Mono<ResponseEntity<String>> registerWebhook(@RequestParam String param) {
    return Mono.just(ResponseEntity.ok().body(""));
  }
  
}
