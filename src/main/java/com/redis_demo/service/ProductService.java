package com.redis_demo.service;

import com.redis_demo.entity.Product;
import com.redis_demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  private final ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public Product getProduct(Long id) {
    return productRepository.findById(id)
      .orElseThrow();
  }
}
