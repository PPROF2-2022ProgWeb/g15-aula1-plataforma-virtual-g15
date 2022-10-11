package com.saberconectar.sc.controller;

import com.saberconectar.sc.dto.SaleDTO;
import com.saberconectar.sc.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("sales")
public class SaleController {
    @Autowired
    private SaleService saleService;
    @GetMapping("/{id}")
    public ResponseEntity<SaleDTO>getSaleById(@PathVariable Long id){
        SaleDTO sale = saleService.getSaleById(id);
        return ResponseEntity.ok().body(sale);
    }
    @PostMapping
    public ResponseEntity<SaleDTO> save(@RequestBody SaleDTO sale){
        SaleDTO saleSaved = saleService.save(sale);
        return ResponseEntity.status(HttpStatus.CREATED).body(saleSaved);
    }
    @PutMapping("/{id}")
    public ResponseEntity<SaleDTO> update(@PathVariable Long id, @RequestBody SaleDTO sale) {
        SaleDTO saleUpdated = this.saleService.update(id, sale);
        return ResponseEntity.ok().body(saleUpdated);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        this.saleService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
