package com.elanza48.gateway.controller.Account;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/account")
public class AccountController {
  

  @RequestMapping(value="/register", method=RequestMethod.POST)
  public Mono<ResponseEntity<String>> accountRegistration(@RequestParam String param) {
    return Mono.just(ResponseEntity.ok().body(""));
  }

  @RequestMapping(value="/authenticate", method=RequestMethod.POST)
  public Mono<ResponseEntity<String>> accountAuthentication(@RequestParam String param) {
    return Mono.just(ResponseEntity.ok().body(""));
  }
  
}
