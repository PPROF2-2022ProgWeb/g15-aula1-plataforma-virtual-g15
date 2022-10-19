package com.saberconectar.sc.auth.repository;

import com.saberconectar.sc.entity.InstitutionEntity;
import com.saberconectar.sc.entity.StudentEntity;

@Repository
public interface UserRegRepository extends JpaRepository<Object<InstitutionEntity, StudentEntity>, Long> {
    Object<InstitutionEntity, StudentEntity> findByUsername(String username);
}
