package com.example.consumer.controller;

import com.example.consumer.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

  @Autowired
  private ConsumerService consumerService;

  @GetMapping("/consumer")
  public Integer consumer(@RequestParam Integer op1, @RequestParam Integer op2){
    return consumerService.consumer(op1, op2);
  }
}
