package com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.repositories;


import com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Optional<Customer> findByEmail(String email);
}
