package com.org.productcatalogue.utils;

import com.org.productcatalogue.exception.BadRequestException;
import com.org.productcatalogue.request.ProductRequest;
import com.org.productcatalogue.request.PriceRequest;
import com.org.productcatalogue.request.AttributeRequest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidationUtils {

    public static void validatePrices(List<PriceRequest> prices) {
        if (prices == null || prices.isEmpty()) {
            throw new BadRequestException("At least one price is required");
        }
        for (PriceRequest price : prices) {
            if (price.getPrice() == null || price.getPrice() < 0) {
                throw new BadRequestException("Price must be positive");
            }
            if (price.getCurrency() == null || price.getCurrency().isEmpty()) {
                throw new BadRequestException("Currency is required");
            }
            if (price.getValidFrom() == null || price.getValidFrom().isEmpty()) {
                throw new BadRequestException("validFrom is required for price");
            }
        }
    }

    public static void validateAttributes(List<AttributeRequest> attributes) {
        if (attributes == null) return;
        Set<String> keys = new HashSet<>();
        for (AttributeRequest attr : attributes) {
            if (attr.getKey() == null || attr.getKey().isEmpty()) {
                throw new BadRequestException("Attribute key is required");
            }
            if (!keys.add(attr.getKey())) {
                throw new BadRequestException("Duplicate attribute key: " + attr.getKey());
            }
        }
    }
}