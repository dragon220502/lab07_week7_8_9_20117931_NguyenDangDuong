package com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.services;

import com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.models.ProductPrice;
import com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.pks.ProductPricePK;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductPriceService {
    List<ProductPrice> getAll();
    Optional<ProductPrice> findById(ProductPricePK productPricePK);
    ProductPrice save(ProductPrice productPrice);
}
