package com.karaca.customertrackingsystem.service;

import com.karaca.customertrackingsystem.dto.requests.create.CreateProductRequest;
import com.karaca.customertrackingsystem.dto.requests.update.UpdateProductRequest;
import com.karaca.customertrackingsystem.dto.responses.create.CreateProductResponse;
import com.karaca.customertrackingsystem.dto.responses.get.Product.GetAllProductsResponse;
import com.karaca.customertrackingsystem.dto.responses.get.Product.GetProductResponse;
import com.karaca.customertrackingsystem.dto.responses.update.UpdateProductResponse;

import java.util.List;

public interface ProductService {
    List<GetAllProductsResponse> getAll();
    GetProductResponse getById(int id);
    CreateProductResponse add(CreateProductRequest request);
    UpdateProductResponse update(int id, UpdateProductRequest request);
    void delete(int id);
}
