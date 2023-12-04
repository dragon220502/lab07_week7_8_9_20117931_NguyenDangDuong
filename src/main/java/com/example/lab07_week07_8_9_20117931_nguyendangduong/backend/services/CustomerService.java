package com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.services;


import com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.models.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CustomerService {
    Customer save(Customer customer);
    List<Customer> getAll();
    Optional<Customer> findById(Long id);
    Optional<Customer> findByEmail(String email);
}
