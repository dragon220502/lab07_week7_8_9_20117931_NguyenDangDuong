package com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.implement;

import fit.se.week7.backend.enums.UserRoleStatus;
import fit.se.week7.backend.enums.UserStatus;
import fit.se.week7.backend.models.User;
import fit.se.week7.backend.repositories.UserRepository;
import fit.se.week7.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserImplement implements UserService {
    @Autowired
    private UserRepository repository;
    @Override
    public Optional<User> findByUserName(String username) {
        return repository.findById(username,UserRoleStatus.ACTIVE);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return repository.findByEmail(email, UserRoleStatus.ACTIVE);
    }

    @Override
    public List<User> getAll() {
        return repository.findAll(UserStatus.ACTIVE);
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }
}
