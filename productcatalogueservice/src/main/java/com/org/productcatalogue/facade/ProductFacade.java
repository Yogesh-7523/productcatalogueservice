package com.org.productcatalogue.facade;

import com.org.productcatalogue.request.ProductRequest;
import com.org.productcatalogue.response.ProductResponse;
import com.org.productcatalogue.service.ProductService;
import com.org.productcatalogue.transformer.ProductTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public interface ProductFacade {

    ProductResponse createProduct(ProductRequest request) ;
}
