package com.redis_demo.infraestructure.persistence;

import com.redis_demo.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataProductRepository extends JpaRepository<Product, Long> {
}
