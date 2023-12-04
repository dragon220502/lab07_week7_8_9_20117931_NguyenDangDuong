package com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.services;

import com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.models.UserRole;
import com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.pks.UserRolePK;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserRoleService {
    List<UserRole> getAll();
    Optional<UserRole> findById(UserRolePK userRolePK);
    UserRole save(UserRole userRole);
}
