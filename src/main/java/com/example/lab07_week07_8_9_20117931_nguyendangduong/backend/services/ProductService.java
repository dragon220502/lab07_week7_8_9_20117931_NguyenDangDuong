package com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.services;

import com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.dto.ProductDto;
import com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {
    List<Product> getAll();
    Optional<Product> findById(long id);
    Product save(Product product);
    Page<ProductDto> findPage(int pageNo, int pageSize, String sortBy, String sortDerection);
    List<ProductDto> getProduct(String userName);
    List<ProductDto> getProduct();
    Optional<ProductDto> findByProdId(Long id);
}
