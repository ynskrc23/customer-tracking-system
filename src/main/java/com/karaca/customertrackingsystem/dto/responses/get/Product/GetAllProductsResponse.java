package com.karaca.customertrackingsystem.dto.responses.get.Product;

import com.karaca.customertrackingsystem.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetAllProductsResponse {
    private Long id;
    private String name;
    private String description;
    private String imageUrl;
    private BigDecimal price;
    private int stock;
    private LocalDateTime dateCreated;
    private Order order;
}
