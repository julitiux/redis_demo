package com.redis_demo.infraestructure.persistence;

import com.redis_demo.domain.entity.Product;
import com.redis_demo.domain.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.util.Optional;

@Repository
public class JpaProductRepository implements ProductRepository {

  private final SpringDataProductRepository repository;

  public JpaProductRepository(SpringDataProductRepository repository) {
    this.repository = repository;
  }

  @Override
  public Optional<Product> findById(Long id) {
    return repository.findById(id);
  }

  @Override
  public Product save(Product product) {
    return repository.save(product);
  }
}
