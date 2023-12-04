package com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.models;

import com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.enums.UserStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private String userName;
    private String passWord;
    private String email;
    @Enumerated(EnumType.STRING)
    private UserStatus status;
}
