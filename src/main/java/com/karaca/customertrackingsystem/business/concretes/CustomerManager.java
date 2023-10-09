package com.karaca.customertrackingsystem.business.concretes;

import com.karaca.customertrackingsystem.business.abstracts.CustomerService;
import com.karaca.customertrackingsystem.business.dto.requests.create.CreateCustomerRequest;
import com.karaca.customertrackingsystem.business.dto.requests.update.UpdateCustomerRequest;
import com.karaca.customertrackingsystem.business.dto.responses.create.CreateCustomerResponse;
import com.karaca.customertrackingsystem.business.dto.responses.get.Customer.GetAllCustomersResponse;
import com.karaca.customertrackingsystem.business.dto.responses.get.Customer.GetCustomerResponse;
import com.karaca.customertrackingsystem.business.dto.responses.update.UpdateCustomerResponse;
import com.karaca.customertrackingsystem.repository.CustomerRepository;
import org.springframework.cache.annotation.Cacheable;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    @Cacheable(value = "customer_list")
    public List<GetAllCustomersResponse> getAll() {
        return null;
    }

    @Override
    public GetCustomerResponse getById(int id) {
        return null;
    }

    @Override
    public CreateCustomerResponse add(CreateCustomerRequest request) {
        return null;
    }

    @Override
    public UpdateCustomerResponse update(int id, UpdateCustomerRequest request) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
