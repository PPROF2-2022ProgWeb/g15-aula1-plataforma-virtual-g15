package com.saberconectar.sc.service;

import com.saberconectar.sc.dto.SaleDTO;
public interface SaleService {
    SaleDTO getSaleById(Long id);
    SaleDTO save(SaleDTO dto);
    SaleDTO update(Long id, SaleDTO sale);
    void delete (Long id);
    void isCorrect(Long id);
}
