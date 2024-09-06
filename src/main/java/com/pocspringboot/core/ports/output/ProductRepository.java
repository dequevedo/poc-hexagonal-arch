package com.pocspringboot.core.ports.output;

import com.pocspringboot.core.model.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    Product save(Product product);

    Optional<Product> findById(Long id);

    List<Product> findAll();

}