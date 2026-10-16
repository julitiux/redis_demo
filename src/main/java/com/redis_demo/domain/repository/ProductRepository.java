package com.redis_demo.domain.repository;

import com.redis_demo.domain.entity.Product;

import java.util.Optional;

public interface ProductRepository {

  Optional<Product> findById(Long id);

  Product save(Product product);
}