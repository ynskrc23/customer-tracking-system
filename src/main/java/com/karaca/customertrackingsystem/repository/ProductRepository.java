package com.karaca.customertrackingsystem.repository;

import com.karaca.customertrackingsystem.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
