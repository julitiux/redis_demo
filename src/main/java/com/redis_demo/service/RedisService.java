package com.redis_demo.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class RedisService {

  private final RedisTemplate<String, String> redisTemplate;

  public RedisService(RedisTemplate<String, String> redisTemplate) {
    this.redisTemplate = redisTemplate;
  }

  public void saveName(String name) {
    redisTemplate
      .opsForValue()
      .set("name", name, Duration.ofSeconds(30));
  }

  public String getName() {
    return redisTemplate.opsForValue().get("name");
  }
}
