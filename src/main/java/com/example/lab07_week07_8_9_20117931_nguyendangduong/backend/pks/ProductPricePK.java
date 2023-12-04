package com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.pks;

import fit.se.week7.backend.models.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductPricePK implements Serializable {
    private Product product;
    private LocalDateTime priceDatetime;
}
