package com.saberconectar.sc.repository;

import com.saberconectar.sc.entity.ProvinceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProvinceRepository extends JpaRepository<ProvinceEntity, Long> {
}
