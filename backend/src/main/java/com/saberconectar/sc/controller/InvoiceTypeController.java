package com.saberconectar.sc.controller;

import com.saberconectar.sc.dto.InvoiceTypeDTO;
import com.saberconectar.sc.service.InvoiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("invoices/types")
public class InvoiceTypeController {
    @Autowired
    private InvoiceTypeService invoiceTypeService;
    @GetMapping
    public ResponseEntity<List<InvoiceTypeDTO>> getAll(){
        List<InvoiceTypeDTO> invoiceTypes = invoiceTypeService.getAllInvoiceTypes();
        return ResponseEntity.ok().body(invoiceTypes);
    }
    @PostMapping
    public ResponseEntity<InvoiceTypeDTO> save(@RequestBody InvoiceTypeDTO type){
        InvoiceTypeDTO invoiceTypeSaved = invoiceTypeService.save(type);
        return ResponseEntity.status(HttpStatus.CREATED).body(invoiceTypeSaved);
    }
    @PutMapping("/{id}")
    public ResponseEntity<InvoiceTypeDTO> update(@PathVariable Long id, @RequestBody InvoiceTypeDTO type) {
        InvoiceTypeDTO invoiceTypeUpdated = invoiceTypeService.update(id, type);
        return ResponseEntity.ok().body(invoiceTypeUpdated);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        invoiceTypeService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
