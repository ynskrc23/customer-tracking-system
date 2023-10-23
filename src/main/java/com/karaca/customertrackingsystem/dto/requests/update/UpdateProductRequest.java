package com.karaca.customertrackingsystem.dto.requests.update;

import com.karaca.customertrackingsystem.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateProductRequest {
    private String name;
    private String description;
    private String imageUrl;
    private BigDecimal price;
    private int stock;
}
