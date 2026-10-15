package com.redis_demo.infraestructure.web;

import com.redis_demo.application.service.ProductApplicationService;
import com.redis_demo.domain.entity.Product;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

  private final ProductApplicationService productApplicationService;

  public ProductController(ProductApplicationService productApplicationService) {
    this.productApplicationService = productApplicationService;
  }

  @GetMapping("/{id}")
  public Product getProduct(@PathVariable Long id) {
    return productApplicationService.getProduct(id);
  }

  @PutMapping("/{id}")
  public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
    return productApplicationService.updateProduct(id, product);
  }
}
