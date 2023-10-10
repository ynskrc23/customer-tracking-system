package com.karaca.customertrackingsystem.controller;

import com.karaca.customertrackingsystem.business.abstracts.CustomerService;
import com.karaca.customertrackingsystem.business.dto.requests.create.CreateCustomerRequest;
import com.karaca.customertrackingsystem.business.dto.responses.create.CreateCustomerResponse;
import com.karaca.customertrackingsystem.business.dto.responses.get.Customer.GetAllCustomersResponse;
import com.karaca.customertrackingsystem.business.dto.responses.get.Customer.GetCustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public List<GetAllCustomersResponse> getAll() {
        return customerService.getAll();
    }

    @GetMapping("/{id}")
    public GetCustomerResponse getById(@PathVariable int id) {
        return customerService.getById(id);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateCustomerResponse add(@RequestBody CreateCustomerRequest request) {
        return customerService.add(request);
    }
}
