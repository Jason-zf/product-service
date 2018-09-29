package com.thoughtworks.training.productsservice.controller;

import com.thoughtworks.training.productsservice.exception.NotFoundException;
import com.thoughtworks.training.productsservice.model.Product;
import com.thoughtworks.training.productsservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> get() {
        return productService.getAll();
    }

    @GetMapping(value = "/{id}")
    public Product get(@PathVariable Long id) throws NotFoundException {
        return productService.getOne(id);
    }

    @PostMapping
    public HttpStatus add(@RequestBody Product product) {
        return productService.addOne(product);
    }

    @PutMapping
    public Product update(@RequestBody Product product) {
        return productService.update(product);
    }

    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable Long id) {
        return productService.deleteOne(id);
    }


}
