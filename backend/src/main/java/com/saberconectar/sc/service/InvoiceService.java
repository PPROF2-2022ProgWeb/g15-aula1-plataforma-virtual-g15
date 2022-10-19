package com.saberconectar.sc.service;

import com.saberconectar.sc.dto.InvoiceDTO;
public interface InvoiceService {
    InvoiceDTO getInvoiceById(Long id);
    InvoiceDTO save(InvoiceDTO dto);
    InvoiceDTO update(Long id, InvoiceDTO dto);
    void delete(Long id);
    void isCorrect(Long id);
}
