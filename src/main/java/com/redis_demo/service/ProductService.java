package com.redis_demo.service;

import com.redis_demo.entity.Product;
import com.redis_demo.repository.ProductRepository;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.time.Duration;
import java.util.Optional;

@Service
public class ProductService {

  private final ProductRepository productRepository;
  private final RedisTemplate<String, String> redisTemplate;
  private final ObjectMapper objectMapper;

  public ProductService(ProductRepository productRepository, RedisTemplate<String, String> redisTemplate, ObjectMapper objectMapper) {
    this.productRepository = productRepository;
    this.redisTemplate = redisTemplate;
    this.objectMapper = objectMapper;
  }

  public Product getProduct(Long id) {

    String key = "product:" + id;

    return Optional.ofNullable(
        redisTemplate.opsForValue().get(key)
      )
      .map(json -> objectMapper.readValue(json, Product.class))
      .orElseGet(() -> {

        Product product = productRepository
          .findById(id)
          .orElseThrow();

        String json = objectMapper.writeValueAsString(product);

        redisTemplate.opsForValue().set(
          key,
          json,
          Duration.ofSeconds(30)
        );
        return product;
      });
  }

  public Product updateProduct(Long id, Product product) {
    Product existingProduct = productRepository.findById(id).orElseThrow();

    existingProduct.setName(product.getName());
    existingProduct.setPrice(product.getPrice());

    Product updatedProduct = productRepository.save(existingProduct);

    redisTemplate.delete("product:" + id);

    return updatedProduct;
  }

}
