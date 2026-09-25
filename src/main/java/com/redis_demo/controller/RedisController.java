package com.redis_demo.controller;

import com.redis_demo.service.RedisService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {

  private final RedisService redisService;

  public RedisController(RedisService redisService) {
    this.redisService = redisService;
  }
}
