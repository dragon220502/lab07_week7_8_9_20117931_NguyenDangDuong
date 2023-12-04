package com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.services;

import com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.models.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface OrderService {
    List<Order> getAll();
    Order save(Order order);
    Optional<Order> findById(Long id);
}
