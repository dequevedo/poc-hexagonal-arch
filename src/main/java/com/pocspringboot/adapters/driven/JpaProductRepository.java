package com.pocspringboot.adapters.driven;

import com.pocspringboot.core.model.domain.Product;
import com.pocspringboot.core.ports.output.ProductRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaProductRepository extends JpaRepository<Product, Long>, ProductRepository {

}