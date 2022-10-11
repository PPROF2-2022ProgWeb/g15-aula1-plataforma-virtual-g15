package com.saberconectar.sc.repository;

import com.saberconectar.sc.entity.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface SaleRepository extends JpaRepository<SaleEntity, Long> {
}
