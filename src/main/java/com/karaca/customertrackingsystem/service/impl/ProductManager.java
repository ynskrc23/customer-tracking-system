package com.karaca.customertrackingsystem.service.impl;

import com.karaca.customertrackingsystem.dto.requests.create.CreateProductRequest;
import com.karaca.customertrackingsystem.dto.requests.update.UpdateProductRequest;
import com.karaca.customertrackingsystem.dto.responses.create.CreateProductResponse;
import com.karaca.customertrackingsystem.dto.responses.get.Product.GetAllProductsResponse;
import com.karaca.customertrackingsystem.dto.responses.get.Product.GetProductResponse;
import com.karaca.customertrackingsystem.dto.responses.update.UpdateProductResponse;
import com.karaca.customertrackingsystem.entity.Product;
import com.karaca.customertrackingsystem.exception.ResourceNotFoundException;
import com.karaca.customertrackingsystem.repository.ProductRepository;
import com.karaca.customertrackingsystem.service.ProductService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper mapper;
    @Override
    @Cacheable(value = "product_list")
    public List<GetAllProductsResponse> getAll() {
        List<Product> products = productRepository.findAll();

        return products.stream().map(product -> mapper.map(product, GetAllProductsResponse.class)).toList();
    }

    @Override
    public GetProductResponse getById(int id) {
        Product product = productRepository.findById((long) id)
                .orElseThrow(()-> new ResourceNotFoundException("Product not found id:"+id));

        return mapper.map(product, GetProductResponse.class);
    }

    @Override
    @CacheEvict(value = "product_list", allEntries = true)
    public CreateProductResponse add(CreateProductRequest request) {
        Product product = mapper.map(request,Product.class);
        product.setId(0L);
        productRepository.save(product);

        return mapper.map(product, CreateProductResponse.class);
    }

    @Override
    public UpdateProductResponse update(int id, UpdateProductRequest request) {
        productRepository.findById((long) id)
                .orElseThrow(()-> new ResourceNotFoundException("Product not found id:"+id));
        Product product = mapper.map(request,Product.class);
        product.setId((long) id);
        productRepository.save(product);

        return mapper.map(product,UpdateProductResponse.class);
    }

    @Override
    public void delete(int id) {
        productRepository.findById((long) id)
                .orElseThrow(()-> new ResourceNotFoundException("Product not found id:"+id));
        productRepository.deleteById((long) id);
    }
}
