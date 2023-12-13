package com.karaca.customertrackingsystem.controller;

import com.karaca.customertrackingsystem.dto.requests.create.CreateOrderRequest;
import com.karaca.customertrackingsystem.dto.requests.update.UpdateOrderRequest;
import com.karaca.customertrackingsystem.dto.responses.create.CreateOrderResponse;
import com.karaca.customertrackingsystem.dto.responses.get.Order.GetAllOrdersResponse;
import com.karaca.customertrackingsystem.dto.responses.get.Order.GetOrderResponse;
import com.karaca.customertrackingsystem.dto.responses.update.UpdateOrderResponse;
import com.karaca.customertrackingsystem.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/orders")
public class OrderController {
    private OrderService orderService;

    @GetMapping
    public List<GetAllOrdersResponse> getAll(){
        return orderService.getAll();
    }

    @GetMapping("/{id}")
    public GetOrderResponse getById(@PathVariable int id){
        return orderService.getById(id);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateOrderResponse add(@RequestBody CreateOrderRequest request) {
        return orderService.add(request);
    }

    @PutMapping("/{id}")
    public UpdateOrderResponse update(@PathVariable int id, @RequestBody UpdateOrderRequest request) {
        return orderService.update(id,request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id){
        orderService.delete(id);
    }
}
