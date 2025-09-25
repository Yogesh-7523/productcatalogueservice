package com.org.productcatalogue.service;

import com.org.productcatalogue.entity.Product;
import com.org.productcatalogue.request.ProductRequest;
import org.springframework.stereotype.Component;

@Component
public interface ProductService {

    Product createProduct(ProductRequest request);
}
