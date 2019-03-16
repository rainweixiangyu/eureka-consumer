package com.example.consumer.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("eureka-client")
public interface CalculatorClient {
  @GetMapping("/add")
  Integer add(@RequestParam(value = "op1") Integer op1, @RequestParam(value = "op2") Integer op2);
}
