package com.redis_demo.domain;

import com.redis_demo.domain.entity.Product;

public interface ProductService {

  public Product getProduct(Long id);
  Product updateProduct(Long id, Product product);
}
