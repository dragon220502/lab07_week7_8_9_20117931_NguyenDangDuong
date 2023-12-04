package com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.repositories;

import com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.enums.UserStatus;
import com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.models.UserRole;
import com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.pks.UserRolePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, UserRolePK> {
    @Query("select ur from UserRole ur join User u on u.userName=ur.userRolePK.user.userName where u.status=:status and ur.status=:status")
    List<UserRole> findAll(@Param("status") UserStatus userStatus);
}
