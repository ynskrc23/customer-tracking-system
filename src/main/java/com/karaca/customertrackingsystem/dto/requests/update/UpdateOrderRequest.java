package com.karaca.customertrackingsystem.dto.requests.update;

import com.karaca.customertrackingsystem.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateOrderRequest {
    private Date orderDate;
    private String status;
    private Customer customer;
}
