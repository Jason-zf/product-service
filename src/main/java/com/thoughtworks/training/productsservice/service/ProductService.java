package com.thoughtworks.training.productsservice.service;

import com.thoughtworks.training.productsservice.exception.NotFoundException;
import com.thoughtworks.training.productsservice.model.Product;
import com.thoughtworks.training.productsservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.net.PortUnreachableException;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public HttpStatus addOne(Product product) {
        productRepository.save(product);
        return HttpStatus.valueOf(201);
    }

    public Product getOne(Long id) throws NotFoundException {
        if (productRepository.findOne(id) == null)
            throw new NotFoundException();
        return productRepository.findOne(id);
    }

    public Product update(Product product) {
        return productRepository.save(product);
    }

    public String deleteOne(Long id) {
        productRepository.delete(id);
        return "delete";
    }
}
