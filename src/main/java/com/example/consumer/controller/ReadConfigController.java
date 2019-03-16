package com.example.consumer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReadConfigController {
  private final static Logger log = LoggerFactory.getLogger(RestController.class);

  @Value("${jdbc.driverClassName}")
  String driverClassName;

  @Value("${jdbc.url}")
  String url;

  @Value("${jdbc.username}")
  String username;

  @Value("${jdbc.password}")
  String password;

  @GetMapping("/config")
  public String config(){
    log.info("Driver:"+driverClassName);
    log.info("URL:"+url);
    log.info("User:"+username);
    log.info("Password:"+password);

    return "success";
  }
}
