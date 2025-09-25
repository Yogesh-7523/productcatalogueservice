package com.org.productcatalogue.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ProductResponse {
    private UUID id;
    private String code;
    private String name;
    private String description;
    private Category category;
    private String status;
    private List<Price> prices;
    private List<Attribute> attributes;
    private Instant createdAt;
    private Instant updatedAt;
}
