package com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Long id;
    private String name;
    private double price;
    private String pathImage;
    private String description;
    private int quantity;
    private double total;

    public ProductDto(Long id, String name, double price, String pathImage, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.pathImage = pathImage;
        this.description = description;
        this.quantity=1;
        this.total=quantity* price;
    }
}
