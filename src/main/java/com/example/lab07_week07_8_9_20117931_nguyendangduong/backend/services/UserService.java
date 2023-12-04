package com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.services;

import com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.models.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    Optional<User> findByUserName(String username);
    Optional<User> findByEmail(String email);
    List<User> getAll();
    User save(User user);
}
