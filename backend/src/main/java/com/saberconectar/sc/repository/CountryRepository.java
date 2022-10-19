package com.saberconectar.sc.repository;

import com.saberconectar.sc.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CountryRepository extends JpaRepository<CountryEntity, Long> {
}
