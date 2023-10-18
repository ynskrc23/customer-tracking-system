package com.karaca.customertrackingsystem.service;

import com.karaca.customertrackingsystem.dto.requests.create.CreateCustomerRequest;
import com.karaca.customertrackingsystem.dto.requests.update.UpdateCustomerRequest;
import com.karaca.customertrackingsystem.dto.responses.create.CreateCustomerResponse;
import com.karaca.customertrackingsystem.dto.responses.get.Customer.GetAllCustomersResponse;
import com.karaca.customertrackingsystem.dto.responses.get.Customer.GetCustomerResponse;
import com.karaca.customertrackingsystem.dto.responses.update.UpdateCustomerResponse;

import java.util.List;

public interface CustomerService {
    List<GetAllCustomersResponse> getAll();
    GetCustomerResponse getById(int id);

    CreateCustomerResponse add(CreateCustomerRequest request);
    UpdateCustomerResponse update(int id, UpdateCustomerRequest request);
    void delete(int id);

}
