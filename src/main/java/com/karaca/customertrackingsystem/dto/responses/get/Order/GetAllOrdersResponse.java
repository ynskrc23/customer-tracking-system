package com.karaca.customertrackingsystem.dto.responses.get.Order;

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
public class GetAllOrdersResponse {
    private int id;
    private Date orderDate;
    private String status;
    private Customer customer;
}
