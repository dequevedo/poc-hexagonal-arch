package com.pocspringboot.core.ports.input;

import com.pocspringboot.core.model.domain.Product;
import com.pocspringboot.core.model.request.CreateProductRequest;
import com.pocspringboot.core.model.response.CreateProductResponse;
import com.pocspringboot.core.model.response.GetProductResponse;

import java.util.List;

public interface ProductService {

    CreateProductResponse createProduct(CreateProductRequest product);

    GetProductResponse getProductById(Long id);

    List<GetProductResponse> getAllProducts();

}
