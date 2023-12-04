package com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.implement;

import fit.se.week7.backend.models.Cart;
import fit.se.week7.backend.pks.CartKey;
import fit.se.week7.backend.repositories.CartRepository;
import fit.se.week7.backend.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CartImpl implements CartService {
    @Autowired
    private CartRepository repository;
    @Override
    public List<Cart> getAll() {
        return repository.findAll();
    }

    @Override
    public Cart save(Cart cart) {
        return repository.save(cart);
    }
    @Override
    public Optional<Cart> findById(CartKey cartKey) {
        return repository.findById(cartKey);
    }
}
