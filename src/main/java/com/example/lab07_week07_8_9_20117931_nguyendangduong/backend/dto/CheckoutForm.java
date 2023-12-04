package com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckoutForm {
    private List<CheckoutDto> products;
}
