package com.org.productcatalogue.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@Table(name = "prices", schema = "productcatalog")
public class Price {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    private String region;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private String currency = "USD";

    @Column(nullable = false)
    private Instant validFrom;

    private Instant validTo;

    @Column(nullable = false)
    private boolean isActive = true;

    private Instant createdAt;

    @PrePersist
    public void prePersist() {
        createdAt = Instant.now();
    }

}