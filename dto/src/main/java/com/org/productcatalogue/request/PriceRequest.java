package com.org.productcatalogue.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PriceRequest {
    private String region;
    private Double price;
    private String currency;
    private String validFrom; // ISO 8601 string
    private String validTo;   // ISO 8601 string
}
