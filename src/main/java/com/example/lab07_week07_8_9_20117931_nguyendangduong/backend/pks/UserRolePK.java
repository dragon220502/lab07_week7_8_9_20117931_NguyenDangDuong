package com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.pks;

import com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.models.Role;
import com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.models.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRolePK implements Serializable {
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}
