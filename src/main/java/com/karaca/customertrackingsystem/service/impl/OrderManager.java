package com.karaca.customertrackingsystem.service.impl;

import com.karaca.customertrackingsystem.dto.requests.create.CreateOrderRequest;
import com.karaca.customertrackingsystem.dto.requests.update.UpdateOrderRequest;
import com.karaca.customertrackingsystem.dto.responses.create.CreateOrderResponse;
import com.karaca.customertrackingsystem.dto.responses.get.Order.GetAllOrdersResponse;
import com.karaca.customertrackingsystem.dto.responses.get.Order.GetOrderResponse;
import com.karaca.customertrackingsystem.dto.responses.update.UpdateOrderResponse;
import com.karaca.customertrackingsystem.entity.Order;
import com.karaca.customertrackingsystem.exception.ResourceNotFoundException;
import com.karaca.customertrackingsystem.repository.OrderRepository;
import com.karaca.customertrackingsystem.service.OrderService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderManager implements OrderService {
    private final OrderRepository orderRepository;
    private final ModelMapper mapper;
    @Override
    @Cacheable(value = "order_list")
    public List<GetAllOrdersResponse> getAll() {
        List<Order> orders = orderRepository.findAll();

        return orders.stream().map(order -> mapper.map(order, GetAllOrdersResponse.class)).toList();
    }

    @Override
    public GetOrderResponse getById(int id) {
        Order order = orderRepository.findById((long) id)
                .orElseThrow(()-> new ResourceNotFoundException("Order not found id:"+id));

        return mapper.map(order, GetOrderResponse.class);
    }

    @Override
    @CacheEvict(value = "order_list", allEntries = true)
    public CreateOrderResponse add(CreateOrderRequest request) {
        Order order = mapper.map(request,Order.class);
        order.setId(0L);
        orderRepository.save(order);

        return mapper.map(order, CreateOrderResponse.class);
    }

    @Override
    public UpdateOrderResponse update(int id, UpdateOrderRequest request) {
        orderRepository.findById((long) id)
                .orElseThrow(()-> new ResourceNotFoundException("Order not found id:"+id));
        Order order = mapper.map(request,Order.class);
        order.setId((long) id);
        orderRepository.save(order);

        return mapper.map(order, UpdateOrderResponse.class);
    }

    @Override
    public void delete(int id) {
        orderRepository.findById((long) id)
                .orElseThrow(()-> new ResourceNotFoundException("Order not found id:"+id));
        orderRepository.deleteById((long) id);
    }
}
