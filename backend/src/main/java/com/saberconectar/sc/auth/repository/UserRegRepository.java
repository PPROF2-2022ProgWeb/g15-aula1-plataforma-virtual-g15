package com.saberconectar.sc.auth.repository;

import com.saberconectar.sc.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRegRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail(String username);
}
