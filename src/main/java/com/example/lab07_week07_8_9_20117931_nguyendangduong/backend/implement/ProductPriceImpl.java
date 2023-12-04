package com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.implement;

import fit.se.week7.backend.models.ProductPrice;
import fit.se.week7.backend.pks.ProductPricePK;
import fit.se.week7.backend.repositories.ProductPriceRepository;
import fit.se.week7.backend.services.ProductPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductPriceImpl implements ProductPriceService {
    @Autowired
    private ProductPriceRepository repository;
    @Override
    public List<ProductPrice> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<ProductPrice> findById(ProductPricePK productPricePK) {
        return repository.findById(productPricePK);
    }

    @Override
    public ProductPrice save(ProductPrice productPrice) {
        return repository.save(productPrice);
    }
}
