package com.pocspringboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pocspringboot.exception.NotFoundException;
import com.pocspringboot.model.domain.ProductDomain;
import com.pocspringboot.model.request.CreateProductRequest;
import com.pocspringboot.model.response.ProductResponse;
import com.pocspringboot.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public ProductResponse createProduct(CreateProductRequest createProductRequest) {
        log.info("Creating new product with name: {}", createProductRequest.getName());

        ProductDomain productDomain = productRepository.save(ProductDomain.valueOf(createProductRequest));

        return ProductResponse.valueOf(productDomain);
    }

    public List<ProductResponse> getProducts() {
        log.info("Getting all products");

        List<ProductResponse> productsResponse = productRepository
                .findAll().stream()
                .map(ProductResponse::valueOf).toList();

        log.info("Products retrieved: {}", productsResponse);

        return productsResponse;
    }

    public ProductResponse getProductById(Long id) {
        log.info("Getting Product with id: {}", id);

        ProductDomain productDomain = productRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Product not found.");
                    throw new NotFoundException();
                });

        log.info("Product retrieved: {}", productDomain);

        return ProductResponse.valueOf(productDomain);
    }

    public void testOLT() {
        String text = "Hardcoded string";
        log.info(text);
    }

}
