package com.saberconectar.sc.repository;

import com.saberconectar.sc.entity.InvoiceTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceTypeRepository extends JpaRepository<InvoiceTypeEntity, Long> {
}
