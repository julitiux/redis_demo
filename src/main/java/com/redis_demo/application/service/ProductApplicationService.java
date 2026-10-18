package com.redis_demo.application.service;

import com.redis_demo.domain.entity.Product;
import com.redis_demo.domain.repository.ProductCache;
import com.redis_demo.domain.repository.ProductRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ProductApplicationService {

  private final ProductRepository productRepository;
  private final ProductCache productCache;

  public ProductApplicationService(ProductRepository productRepository, ProductCache productCache) {
    this.productRepository = productRepository;
    this.productCache = productCache;
  }

  @Cacheable(cacheNames = "products", key = "#id")
  public Product getProduct(Long id) {

    return productRepository.findById(id).orElseThrow();
  }

  @CacheEvict(cacheNames = "products", key = "#id")
  public Product updateProduct(Long id, Product product) {

    return productRepository.findById(id)
      .map(existingProduct -> {
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        return productRepository.save(existingProduct);
      })
      .map(updatedProduct -> {
        productCache.evict(id);
        return updatedProduct;
      })
      .orElseThrow();
  }
}
