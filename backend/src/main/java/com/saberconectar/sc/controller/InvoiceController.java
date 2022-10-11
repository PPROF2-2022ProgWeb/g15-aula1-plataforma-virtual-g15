package com.saberconectar.sc.controller;

import com.saberconectar.sc.dto.InvoiceDTO;
import com.saberconectar.sc.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("invoices")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;
    @GetMapping("/{id}")
    public ResponseEntity<InvoiceDTO> getInvoiceById(@PathVariable Long id){
        InvoiceDTO invoice = invoiceService.getInvoiceById(id);
        return ResponseEntity.ok().body(invoice);
    }
    @PostMapping
    public ResponseEntity<InvoiceDTO> save(@RequestBody InvoiceDTO invoice){
        InvoiceDTO invoiceSaved = invoiceService.save(invoice);
        return ResponseEntity.status(HttpStatus.CREATED).body(invoiceSaved);
    }
    @PutMapping("/{id}")
    public ResponseEntity<InvoiceDTO> update(@PathVariable Long id, @RequestBody InvoiceDTO invoice) {
        InvoiceDTO invoiceUpdated = this.invoiceService.update(id, invoice);
        return ResponseEntity.ok().body(invoiceUpdated);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        this.invoiceService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
