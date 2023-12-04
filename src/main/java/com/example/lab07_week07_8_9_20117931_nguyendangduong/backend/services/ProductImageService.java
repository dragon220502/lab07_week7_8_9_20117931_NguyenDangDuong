package com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.services;

import com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.models.ProductImage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductImageService {
    List<ProductImage> getAll();
    ProductImage save(ProductImage productImage);
}
