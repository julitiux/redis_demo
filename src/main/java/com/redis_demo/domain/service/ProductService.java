package com.redis_demo.domain.service;

import com.redis_demo.domain.entity.Product;

public interface ProductService {

  public Product getProduct(Long id);

  public Product updateProduct(Long id, Product product);
}
