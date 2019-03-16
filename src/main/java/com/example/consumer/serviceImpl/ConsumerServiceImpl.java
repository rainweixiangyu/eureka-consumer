package com.example.consumer.serviceImpl;

import com.example.consumer.service.ConsumerService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class ConsumerServiceImpl implements ConsumerService {
  private final static Logger log = LoggerFactory.getLogger(ConsumerServiceImpl.class);

  @Autowired
  private RestTemplate restTemplate;

  @Override
  @HystrixCommand(
          commandProperties = {
                  @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1000"),
                  @HystrixProperty(name = "execution.isolation.strategy",value = "THREAD")
          },
          fallbackMethod = "consumerFallback"
  )
  public Integer consumer(Integer op1, Integer op2){

    //调用服务
    String url = "http://eureka-client/add";
    UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
            .queryParam("op1",op1)
            .queryParam("op2",op2);

    log.info(builder.toUriString());
    return restTemplate.getForObject(builder.toUriString(), Integer.class);
  }

  @Override
  public Integer consumerFallback(Integer op1, Integer op2){
    return -1;
  }
}
