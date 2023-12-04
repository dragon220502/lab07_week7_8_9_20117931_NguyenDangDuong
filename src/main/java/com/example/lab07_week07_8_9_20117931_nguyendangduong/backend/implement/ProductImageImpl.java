package com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.implement;

import fit.se.week7.backend.models.ProductImage;
import fit.se.week7.backend.repositories.ProductImageRepository;
import fit.se.week7.backend.services.ProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductImageImpl implements ProductImageService {
    @Autowired
    private ProductImageRepository repository;
    @Override
    public List<ProductImage> getAll() {
        return repository.findAll();
    }

    @Override
    public ProductImage save(ProductImage productImage) {
        return repository.save(productImage);
    }
}
