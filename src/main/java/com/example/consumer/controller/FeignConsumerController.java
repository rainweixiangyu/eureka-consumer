package com.example.consumer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignConsumerController {
  private final static Logger log = LoggerFactory.getLogger(FeignConsumerController.class);

  @Autowired
  private CalculatorClient calculatorClient;

  @GetMapping("/feignConsumer")
  public Integer consumer(@RequestParam Integer op1, @RequestParam Integer op2){
    return calculatorClient.add(op1,op2);
  }
}
