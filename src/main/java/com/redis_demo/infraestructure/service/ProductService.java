package com.redis_demo.infraestructure.service;

import com.redis_demo.domain.ProductDomainService;
import com.redis_demo.domain.entity.Product;
import com.redis_demo.domain.repository.ProductRepository;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.time.Duration;
import java.util.Optional;

@Service
public class ProductService {

  private final ProductDomainService productDomainService;
  private final RedisTemplate<String, String> redisTemplate;
  private final ObjectMapper objectMapper;

  public ProductService(ProductRepository productRepository, ProductDomainService productDomainService, RedisTemplate<String, String> redisTemplate, ObjectMapper objectMapper) {
    this.productDomainService = productDomainService;
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

        Product product = productDomainService
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

    return productDomainService.findById(id)
      .map(existingProduct -> {
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());

        return productDomainService.save(existingProduct);
      })
      .map(supdateProduct -> {
        redisTemplate.delete("product:" + id);

        return supdateProduct;
      })
      .orElseThrow();
  }
}
