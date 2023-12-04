package com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.pks;

import com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.models.Order;
import com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.models.Product;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailPK implements Serializable {
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @JoinColumn(name = "product_id")
    @ManyToOne
    private Product product;
}
