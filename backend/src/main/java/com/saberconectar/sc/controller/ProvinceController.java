package com.saberconectar.sc.controller;

import com.saberconectar.sc.dto.ProvinceDTO;
import com.saberconectar.sc.service.ProvinceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/provinces")
@Api(tags="Provincias")
public class ProvinceController {
    @Autowired
    private ProvinceService provinceService;
    @GetMapping
    @ApiOperation("Listar todas las provincias")
    public ResponseEntity<List<ProvinceDTO>> getAll(){
        List<ProvinceDTO> provinces = provinceService.getAllProvinces();
        return ResponseEntity.ok().body(provinces);
    }
    @PostMapping
    @ApiOperation("Guardar provincia")
    public ResponseEntity<ProvinceDTO> save(@RequestBody ProvinceDTO province){
        ProvinceDTO provinceSaved = provinceService.save(province);
        return ResponseEntity.status(HttpStatus.CREATED).body(provinceSaved);
    }
    @PutMapping("/{id}")
    @ApiOperation("Actualizar provincia")
    public ResponseEntity<ProvinceDTO> update(@PathVariable Long id, @RequestBody ProvinceDTO province) {
        ProvinceDTO provinceUpdated = this.provinceService.update(id, province);
        return ResponseEntity.ok().body(provinceUpdated);
    }
    @DeleteMapping("/{id}")
    @ApiOperation("Borrar provincia")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        this.provinceService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
