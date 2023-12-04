package com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.implement;

import fit.se.week7.backend.dto.ProductDto;
import fit.se.week7.backend.enums.CartStatus;
import fit.se.week7.backend.models.Product;
import fit.se.week7.backend.repositories.ProductRepository;
import fit.se.week7.backend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductImplement implements ProductService {
    @Autowired
    private ProductRepository repository;
    @Override
    public List<Product> getAll() {

        return repository.findAll();
    }

    @Override
    public Optional<Product> findById(long id) {
        return repository.findById(id);
    }
    @Override
    public Page<ProductDto> findPage(int pageNo, int pageSize, String sortBy, String sortDerection) {
        Sort sort= Sort.by(Sort.Direction.fromString(sortDerection),sortBy);
        Pageable pageable= PageRequest.of(pageNo,pageSize,sort);
        return repository.getProduct(pageable);
    }

    @Override
    public List<ProductDto> getProduct(String userName) {
        return repository.getProduct(userName, CartStatus.INCART);
    }

    @Override
    public List<ProductDto> getProduct() {
        return repository.getProduct();
    }

    @Override
    public Optional<ProductDto> findByProdId(Long id) {
        return repository.findByProdId(id);
    }

    @Override
    public Product save(Product product) {
        return repository.save(product);
    }
}
