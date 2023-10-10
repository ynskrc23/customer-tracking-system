package com.karaca.customertrackingsystem.business.concretes;

import com.karaca.customertrackingsystem.business.abstracts.CustomerService;
import com.karaca.customertrackingsystem.business.dto.requests.create.CreateCustomerRequest;
import com.karaca.customertrackingsystem.business.dto.requests.update.UpdateCustomerRequest;
import com.karaca.customertrackingsystem.business.dto.responses.create.CreateCustomerResponse;
import com.karaca.customertrackingsystem.business.dto.responses.get.Customer.GetAllCustomersResponse;
import com.karaca.customertrackingsystem.business.dto.responses.get.Customer.GetCustomerResponse;
import com.karaca.customertrackingsystem.business.dto.responses.update.UpdateCustomerResponse;
import com.karaca.customertrackingsystem.entity.Customer;
import com.karaca.customertrackingsystem.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapper mapper;
    @Override
    @Cacheable(value = "customer_list")
    public List<GetAllCustomersResponse> getAll() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream().map(customer -> mapper.map(customer, GetAllCustomersResponse.class)).toList();
    }

    @Override
    public GetCustomerResponse getById(int id) {
        Customer customer = customerRepository.findById((long) id).orElseThrow();
        return mapper.map(customer, GetCustomerResponse.class);
    }

    @Override
    @CacheEvict(value = "customer_list", allEntries = true)
    public CreateCustomerResponse add(CreateCustomerRequest request) {
        Customer customer = mapper.map(request,Customer.class);
        customer.setId(0L);
        customerRepository.save(customer);
        return mapper.map(customer,CreateCustomerResponse.class);
    }

    @Override
    public UpdateCustomerResponse update(int id, UpdateCustomerRequest request) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
