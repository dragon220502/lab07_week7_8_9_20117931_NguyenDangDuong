package com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.services;

import com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.models.Cart;
import com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.pks.CartKey;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CartService {
    List<Cart> getAll();
    Cart save(Cart cart);
    Optional<Cart> findById(CartKey cartKey);
}
