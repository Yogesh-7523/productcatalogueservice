package com.org.productcatalogue.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ProductRequest {

    private String code;
    private String name;
    private String description;
    private UUID categoryId;
    private String status; // "ACTIVE", "INACTIVE", "ARCHIVED"
    private List<PriceRequest> prices;
    private List<AttributeRequest> attributes;


}
