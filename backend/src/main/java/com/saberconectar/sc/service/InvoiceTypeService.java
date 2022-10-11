package com.saberconectar.sc.service;

import com.saberconectar.sc.dto.InvoiceTypeDTO;
import java.util.List;
public interface InvoiceTypeService {
    List<InvoiceTypeDTO> getAllInvoiceTypes();
    InvoiceTypeDTO save(InvoiceTypeDTO type);
    InvoiceTypeDTO update(Long id, InvoiceTypeDTO type);
    void delete (Long id);
    void isCorrect(Long id);
}
