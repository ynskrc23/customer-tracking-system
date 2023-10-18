package com.karaca.customertrackingsystem.controller;

import com.karaca.customertrackingsystem.dto.requests.update.UpdateCustomerRequest;
import com.karaca.customertrackingsystem.dto.responses.update.UpdateCustomerResponse;
import com.karaca.customertrackingsystem.service.CustomerService;
import com.karaca.customertrackingsystem.dto.requests.create.CreateCustomerRequest;
import com.karaca.customertrackingsystem.dto.responses.create.CreateCustomerResponse;
import com.karaca.customertrackingsystem.dto.responses.get.Customer.GetAllCustomersResponse;
import com.karaca.customertrackingsystem.dto.responses.get.Customer.GetCustomerResponse;
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

    @PutMapping("/{id}")
    public UpdateCustomerResponse update(@PathVariable int id, @RequestBody UpdateCustomerRequest request) {
        return customerService.update(id,request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id){
        customerService.delete(id);
    }
}
