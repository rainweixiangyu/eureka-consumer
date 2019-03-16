package com.example.consumer.service;

public interface ConsumerService {
  Integer consumer(Integer op1, Integer op2);
  Integer consumerFallback(Integer op1, Integer op2);
}
