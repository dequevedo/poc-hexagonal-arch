package com.pocspringboot.repository;

import com.pocspringboot.model.domain.ProductDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductDomain, Long> {
    List<ProductDomain> findAll();

    ProductDomain save(ProductDomain productDomain);

    Optional<ProductDomain> findById(String id);
}