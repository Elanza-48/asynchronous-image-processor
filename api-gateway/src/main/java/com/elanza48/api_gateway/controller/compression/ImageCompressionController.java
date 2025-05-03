package com.elanza48.api_gateway.controller.compression;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/compression")
public class ImageCompressionController {

  @RequestMapping(value="/", method=RequestMethod.POST)
  public Mono<ResponseEntity<String>> requestProcessor(@RequestParam String param) {
    return Mono.just(ResponseEntity.ok().body(""));
  }

  @RequestMapping(value="/{requestId}/status", method=RequestMethod.GET)
  public Mono<ResponseEntity<String>> requestStatus(@PathVariable String requestId, @RequestParam String param) {
    return Mono.just(ResponseEntity.ok().body(""));
  }
}
