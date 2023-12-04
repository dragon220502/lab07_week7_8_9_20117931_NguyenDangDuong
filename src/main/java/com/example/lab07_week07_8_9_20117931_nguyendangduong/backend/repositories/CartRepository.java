package com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.repositories;
import com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.models.Cart;
import com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.pks.CartKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, CartKey> {
}
