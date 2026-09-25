package com.redis_demo.controller;

import com.redis_demo.service.RedisService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis")
public class RedisController {

  private final RedisService redisService;

  public RedisController(RedisService redisService) {
    this.redisService = redisService;
  }

  @PostMapping("/name")
  public void  saveName(@RequestParam String name) {
    redisService.saveName(name);
  }

  @GetMapping("/name")
  public String getName(){
    return redisService.getName();
  }
}
