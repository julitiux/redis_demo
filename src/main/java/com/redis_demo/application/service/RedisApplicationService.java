package com.redis_demo.application.service;

import com.redis_demo.infraestructure.service.RedisService;
import org.springframework.stereotype.Service;

@Service
public class RedisApplicationService {

  private final RedisService redisService;

  public RedisApplicationService(RedisService redisService) {
    this.redisService = redisService;
  }

  public void saveName(String name) {
    redisService.saveName(name);
  }

  public String getName() {
    return redisService.getName();
  }
}
