package com.redis_demo.infraestructure.cache;

import com.redis_demo.domain.entity.Product;
import com.redis_demo.domain.repository.ProductCache;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import tools.jackson.databind.ObjectMapper;

import java.time.Duration;
import java.util.Optional;

@Repository
public class RedisProductCache implements ProductCache {

  private static final String KEY_PREFIX = "product:";
  private static final Duration TTL = Duration.ofSeconds(30);

  private final RedisTemplate<String, String> redisTemplate;
  private final ObjectMapper objectMapper;

  public RedisProductCache(RedisTemplate<String, String> redisTemplate, ObjectMapper objectMapper) {
    this.redisTemplate = redisTemplate;
    this.objectMapper = objectMapper;
  }

  @Override
  public Optional<Product> findById(Long id) {

    String json = redisTemplate.opsForValue()
      .get(KEY_PREFIX + id);

    return Optional.ofNullable(json)
      .map(value -> objectMapper.convertValue(value, Product.class));
  }

  @Override
  public void save(Product product) {

    String json = objectMapper.writeValueAsString(product);

    redisTemplate.opsForValue().set(
      KEY_PREFIX + product.getId(),
      json,
      TTL
    );
  }

  @Override
  public void evict(Long id) {

    redisTemplate.delete(KEY_PREFIX + id);
  }
}
