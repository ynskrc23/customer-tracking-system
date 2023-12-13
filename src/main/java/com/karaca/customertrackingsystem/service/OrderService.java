package com.karaca.customertrackingsystem.service;

import com.karaca.customertrackingsystem.dto.requests.create.CreateOrderRequest;
import com.karaca.customertrackingsystem.dto.requests.update.UpdateOrderRequest;
import com.karaca.customertrackingsystem.dto.responses.create.CreateOrderResponse;
import com.karaca.customertrackingsystem.dto.responses.get.Order.GetAllOrdersResponse;
import com.karaca.customertrackingsystem.dto.responses.get.Order.GetOrderResponse;
import com.karaca.customertrackingsystem.dto.responses.update.UpdateOrderResponse;

import java.util.List;

public interface OrderService {
    List<GetAllOrdersResponse> getAll();
    GetOrderResponse getById(int id);
    CreateOrderResponse add(CreateOrderRequest request);
    UpdateOrderResponse update(int id, UpdateOrderRequest request);
    void delete(int id);
}
