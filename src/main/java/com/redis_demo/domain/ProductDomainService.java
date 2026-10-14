package com.redis_demo.domain;

import com.redis_demo.domain.entity.Product;

public interface ProductDomainService {

  public Product getProduct(Long id);
  Product updateProduct(Long id, Product product);
}
