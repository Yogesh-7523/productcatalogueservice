package com.org.productcatalogue.service.impl;

import com.org.productcatalogue.entity.Category;
import com.org.productcatalogue.entity.Price;
import com.org.productcatalogue.entity.Product;
import com.org.productcatalogue.entity.ProductAttribute;
import com.org.productcatalogue.repository.CategoryRepository;
import com.org.productcatalogue.repository.ProductRepository;
import com.org.productcatalogue.request.ProductRequest;
import com.org.productcatalogue.service.ProductService;
import com.org.productcatalogue.utils.ValidationUtils;
import com.org.productcatalogue.exception.BadRequestException;
import com.org.productcatalogue.exception.NotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Override
    @Transactional
    public Product createProduct(ProductRequest request) {
        // Validate unique code
        if (productRepository.existsByCode(request.getCode())) {
            throw new BadRequestException("Product code already exists");
        }

        // Validate category
        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new NotFoundException("Category not found")).getCategory();

        // Validate prices
        ValidationUtils.validatePrices(request.getPrices());

        // Build Product
        Product product = Product.builder()
                .code(request.getCode())
                .name(request.getName())
                .description(request.getDescription())
                .category(category)
                .status(request.getStatus())
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .build();

        // Prices
        if (request.getPrices() != null) {
            product.setPrices(request.getPrices().stream().map(priceReq ->
                    Price.builder()
                            .product(product)
                            .region(priceReq.getRegion())
                            .price(java.math.BigDecimal.valueOf(priceReq.getPrice()))
                            .currency(priceReq.getCurrency())
                            .validFrom(Instant.parse(priceReq.getValidFrom()))
                            .validTo(priceReq.getValidTo() != null ? Instant.parse(priceReq.getValidTo()) : null)
                            .isActive(true)
                            .createdAt(Instant.now())
                            .build()
            ).collect(Collectors.toList()));
        }

        // Attributes
        if (request.getAttributes() != null) {
            product.setAttributes(request.getAttributes().stream().map(attrReq ->
                    ProductAttribute.builder()
                            .product(product)
                            .key(attrReq.getKey())
                            .value(attrReq.getValue())
                            .createdAt(Instant.now())
                            .build()
            ).collect(Collectors.toList()));
        }

        return productRepository.save(product);
    }
}
