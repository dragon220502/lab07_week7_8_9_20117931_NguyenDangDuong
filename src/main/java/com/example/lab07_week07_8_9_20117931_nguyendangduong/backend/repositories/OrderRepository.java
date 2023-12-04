package com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.repositories;

import com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
}
