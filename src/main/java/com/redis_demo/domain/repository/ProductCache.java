package com.redis_demo.domain.repository;

import com.redis_demo.domain.entity.Product;

import java.util.Optional;

public interface ProductCache {

  Optional<Product> findById(Long id);

  void save(Product product);

  void evict(Long id);
}
