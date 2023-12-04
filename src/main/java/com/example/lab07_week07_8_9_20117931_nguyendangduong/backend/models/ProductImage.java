package com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product_image")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private Long image_id;
    @Column(name = "path", length = 250, nullable = false)
    private String path;
    @Column(name = "alternative", length = 250)
    private String alternative;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public ProductImage(String path, String alternative, Product product) {
        this.path = path;
        this.alternative = alternative;
        this.product = product;
    }
}
