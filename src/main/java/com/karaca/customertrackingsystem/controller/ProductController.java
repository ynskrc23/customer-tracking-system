package com.karaca.customertrackingsystem.controller;

import com.karaca.customertrackingsystem.dto.requests.create.CreateProductRequest;
import com.karaca.customertrackingsystem.dto.requests.update.UpdateProductRequest;
import com.karaca.customertrackingsystem.dto.responses.create.CreateProductResponse;
import com.karaca.customertrackingsystem.dto.responses.get.Product.GetAllProductsResponse;
import com.karaca.customertrackingsystem.dto.responses.get.Product.GetProductResponse;
import com.karaca.customertrackingsystem.dto.responses.update.UpdateProductResponse;
import com.karaca.customertrackingsystem.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<GetAllProductsResponse> getAll(){
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public GetProductResponse getById(@PathVariable int id){
        return productService.getById(id);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateProductResponse add(@RequestBody CreateProductRequest request){
        return productService.add(request);
    }

    @PutMapping("/{id}")
    public UpdateProductResponse update(@PathVariable int id, @RequestBody UpdateProductRequest request){
        return productService.update(id,request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id){
        productService.delete(id);
    }
}
