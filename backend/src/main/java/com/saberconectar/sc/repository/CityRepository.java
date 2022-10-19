package com.saberconectar.sc.repository;

import com.saberconectar.sc.entity.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CityRepository extends JpaRepository<CityEntity, Long> {
}
