package com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.services;

import com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.enums.RoleName;
import com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.models.Role;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface RoleService {
    List<Role> getAll();
    Optional<Role> findByRoleName(RoleName name);
    Role save(Role role);
    List<Role> findByUserName(String name);
}
