package com.org.productcatalogue.repository;

import com.org.productcatalogue.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PriceRepository extends JpaRepository<Product, UUID> {
}
