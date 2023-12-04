package com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.services;

import com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.models.OrderDetail;
import com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.pks.OrderDetailPK;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface OrderDetailsService {
    List<OrderDetail> getAll();
    Optional<OrderDetail> findBYId(OrderDetailPK orderDetailPK);
    OrderDetail save(OrderDetail orderDetail);
}
