package com.redis_demo.domain;

import com.redis_demo.domain.entity.Product;
import com.redis_demo.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductDomainService {

  private final ProductRepository productRepository;

  public ProductDomainService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public Optional<Product> findById(Long id) {
    return productRepository.findById(id);
  }

  public Product save(Product product) {
    return productRepository.save(product);
  }
}
