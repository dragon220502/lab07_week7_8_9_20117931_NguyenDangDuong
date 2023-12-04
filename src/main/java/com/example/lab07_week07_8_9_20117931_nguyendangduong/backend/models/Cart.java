package com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.models;

import com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.enums.CartStatus;
import com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.pks.CartKey;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "carts")
public class Cart {
    @Id
    @Enumerated
    private CartKey id;
    @Enumerated(EnumType.STRING)
    private CartStatus status;
}
