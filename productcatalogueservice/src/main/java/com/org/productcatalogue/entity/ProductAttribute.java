package com.org.productcatalogue.entity;

import com.org.productcatalogue.entity.Product;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.Instant;
import java.util.UUID;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@Table(name = "product_attributes", schema = "productcatalog")
public class ProductAttribute {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "attr_key", nullable = false)
    private String key;

    @Column(name = "attr_value")
    private String value;

    private Instant createdAt;

    @PrePersist
    public void prePersist() {
        createdAt = Instant.now();
    }
}