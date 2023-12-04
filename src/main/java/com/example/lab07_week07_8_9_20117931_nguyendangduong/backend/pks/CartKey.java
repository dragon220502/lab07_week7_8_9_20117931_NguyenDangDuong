package com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.pks;

import com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.models.Product;
import com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.models.User;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class CartKey implements Serializable {
    @ManyToOne
    private Product product;
    @ManyToOne
    private User user;
}
