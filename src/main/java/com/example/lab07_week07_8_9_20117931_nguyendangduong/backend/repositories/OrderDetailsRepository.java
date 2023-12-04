package com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.repositories;


import com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.models.OrderDetail;
import com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.pks.OrderDetailPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetail, OrderDetailPK> {
}
