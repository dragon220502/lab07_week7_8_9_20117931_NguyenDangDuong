package com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.models;

import com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.enums.UserRoleStatus;
import com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.pks.UserRolePK;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "user_role")
@AllArgsConstructor
@NoArgsConstructor
public class UserRole {
    @Id
    private UserRolePK userRolePK;
    @Enumerated(EnumType.STRING)
    private UserRoleStatus status;
}
