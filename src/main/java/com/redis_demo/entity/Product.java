package com.redis_demo.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Product {

  private long id;
  private String name;
  private BigDecimal price;

  public Product(String name, BigDecimal price) {
    this.name = name;
    this.price = price;
  }
}
