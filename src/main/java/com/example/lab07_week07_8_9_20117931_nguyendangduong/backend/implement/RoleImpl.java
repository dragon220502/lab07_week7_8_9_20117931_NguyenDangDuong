package com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.implement;

import fit.se.week7.backend.enums.RoleName;
import fit.se.week7.backend.enums.UserStatus;
import fit.se.week7.backend.models.Role;
import fit.se.week7.backend.repositories.RoleRepository;
import fit.se.week7.backend.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class RoleImpl implements RoleService {
    @Autowired
    private RoleRepository repository;
    @Override
    public List<Role> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Role> findByRoleName(RoleName name) {
        return repository.findByRoleName(name);
    }

    @Override
    public Role save(Role role) {
        return repository.save(role);
    }

    @Override
    public List<Role> findByUserName(String name) {
        return repository.findByUserName(name, UserStatus.ACTIVE);
    }
}
