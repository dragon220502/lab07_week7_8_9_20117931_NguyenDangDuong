package com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.dto;

import fit.se.week7.backend.enums.TypePayment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupDto {
    private String userName;
    private String passWord;
    private String confirmPassWord;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String note;
    private TypePayment typePayment;
}
