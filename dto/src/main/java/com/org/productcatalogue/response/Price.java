package com.org.productcatalogue.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.Instant;
import java.util.UUID;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Price {
    private UUID id;
    private String region;
    private Double price;
    private String currency;
    private String validFrom;
    private String validTo;
    private Boolean isActive;
    private Instant createdAt;
}
