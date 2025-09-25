package com.org.productcatalogue.transformer;

import com.org.productcatalogue.entity.Product;
import com.org.productcatalogue.response.Attribute;
import com.org.productcatalogue.response.Category;
import com.org.productcatalogue.response.Price;
import com.org.productcatalogue.response.ProductResponse;

import java.util.stream.Collectors;

public class ProductTransformer {

    public ProductResponse toResponse(Product product) {
        if (product == null) {
            return null;
        }

        // Build response
        ProductResponse response = ProductResponse.builder()
                .id(product.getId())
                .code(product.getCode())
                .name(product.getName())
                .description(product.getDescription())
                .status(product.getStatus())
                .createdAt(product.getCreatedAt())
                .updatedAt(product.getUpdatedAt())
                .build();

        // Category
        if (product.getCategory() != null) {
            Category category = Category.builder()
                    .id(product.getCategory().getId())
                    .name(product.getCategory().getName())
                    .build();
            response.setCategory(category);
        }

        // Prices
        if (product.getPrices() != null) {
            response.setPrices(product.getPrices().stream().map(price ->
                    Price.builder()
                            .id(price.getId())
                            .region(price.getRegion())
                            .price(price.getPrice() != null ? price.getPrice().doubleValue() : null)
                            .currency(price.getCurrency())
                            .validFrom(price.getValidFrom() != null ? price.getValidFrom().toString() : null)
                            .validTo(price.getValidTo() != null ? price.getValidTo().toString() : null)
                            .isActive(price.isActive())
                            .createdAt(price.getCreatedAt())
                            .build()
            ).collect(Collectors.toList()));
        }

        // Attributes
        if (product.getAttributes() != null) {
            response.setAttributes(product.getAttributes().stream().map(attr ->
                    Attribute.builder()
                            .id(attr.getId())
                            .key(attr.getKey())
                            .value(attr.getValue())
                            .createdAt(attr.getCreatedAt())
                            .build()
            ).collect(Collectors.toList()));
        }

        return response;
    }
}
