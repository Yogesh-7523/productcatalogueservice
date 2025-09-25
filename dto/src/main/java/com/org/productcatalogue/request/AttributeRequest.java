package com.org.productcatalogue.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class AttributeRequest {
    private String key;
    private String value;
}
