package com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Data
public class CheckoutDto {
    private Long id;
    private String name;
    private double price;
    private int quantity;
    private double total;

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setTotal(double total) {
        this.total = quantity*price;
    }

    public CheckoutDto(Long id,String name, double price, int quantity, double total) {
        this.id = id;
        this.name=name;
        this.price = price;
        this.quantity = quantity;
        this.total = price*quantity;
    }
}
