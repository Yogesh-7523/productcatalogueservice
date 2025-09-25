package com.org.productcatalogue.facade.impl;

import com.org.productcatalogue.entity.Product;
import com.org.productcatalogue.request.ProductRequest;
import com.org.productcatalogue.response.ProductResponse;
import com.org.productcatalogue.service.ProductService;
import com.org.productcatalogue.transformer.ProductTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class ProductFacadeImpl {

    private final ProductService productService;
    private final ProductTransformer productTransformer;

    public ProductFacadeImpl(ProductService productService, ProductTransformer productTransformer) {
        this.productService = productService;
        this.productTransformer = productTransformer;
    }

    public ProductResponse createProduct(ProductRequest request) {
        Product product = productService.createProduct(request);
        return productTransformer.toResponse(product);
    }
}
