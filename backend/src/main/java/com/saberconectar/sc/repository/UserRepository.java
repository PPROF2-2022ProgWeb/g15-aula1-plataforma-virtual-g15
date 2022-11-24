package com.saberconectar.sc.repository;

import com.saberconectar.sc.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity getReferenceByEmail(String email);
    boolean existsByEmail(String username);
    UserEntity findByEmail(String username);
}
