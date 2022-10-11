package com.saberconectar.sc.repository;

import com.saberconectar.sc.entity.InstitutionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface InstitutionRepository extends JpaRepository<InstitutionEntity, Long> {
}
