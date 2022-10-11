package com.saberconectar.sc.controller;

import com.saberconectar.sc.dto.ProvinceDTO;
import com.saberconectar.sc.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("provinces")
public class ProvinceController {
    @Autowired
    private ProvinceService provinceService;
    @GetMapping
    public ResponseEntity<List<ProvinceDTO>> getAll(){
        List<ProvinceDTO> provinces = provinceService.getAllProvinces();
        return ResponseEntity.ok().body(provinces);
    }
    @PostMapping
    public ResponseEntity<ProvinceDTO> save(@RequestBody ProvinceDTO province){
        ProvinceDTO provinceSaved = provinceService.save(province);
        return ResponseEntity.status(HttpStatus.CREATED).body(provinceSaved);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProvinceDTO> update(@PathVariable Long id, @RequestBody ProvinceDTO province) {
        ProvinceDTO provinceUpdated = this.provinceService.update(id, province);
        return ResponseEntity.ok().body(provinceUpdated);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        this.provinceService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
