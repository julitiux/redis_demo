package com.redis_demo.controller;

import com.redis_demo.domain.entity.Product;
import com.redis_demo.infraestructure.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping("/{id}")
  public Product getProduct(@PathVariable Long id) {
    return productService.getProduct(id);
  }

  @PutMapping("/{id}")
  public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
    return productService.updateProduct(id, product);
  }
}
