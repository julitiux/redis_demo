package com.redis_demo.infraestructure.web;

import com.redis_demo.application.service.RedisApplicationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis")
public class RedisController {

  private final RedisApplicationService redisApplicationService;

  public RedisController(RedisApplicationService redisApplicationService) {
    this.redisApplicationService = redisApplicationService;
  }

  @PostMapping("/name")
  public void saveName(@RequestParam String name) {
    redisApplicationService.saveName(name);
  }

  @GetMapping("/name")
  public String getName() {
    return redisApplicationService.getName();
  }
}
