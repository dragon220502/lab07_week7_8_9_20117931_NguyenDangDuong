package com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.models;

import com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.pks.ProductPricePK;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "product_price")
@IdClass(ProductPricePK.class)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductPrice {
//    @Id
    @JoinColumn(name = "prod_id")
    @ManyToOne
    private Product product;
    @Id
    @Column(name = "price_date_time")
    private LocalDateTime priceDatetime;
    @Column(name = "price", nullable = false)
    private double price;
    @Column(name = "note")
    private String note;
}
