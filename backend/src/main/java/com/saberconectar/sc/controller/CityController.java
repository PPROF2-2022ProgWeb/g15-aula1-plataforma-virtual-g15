package com.saberconectar.sc.controller;

import com.saberconectar.sc.dto.CityDTO;
import com.saberconectar.sc.service.CityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
@Api(tags="Ciudades")
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping
    @ApiOperation("Listar todas las ciudades")
    public ResponseEntity<List<CityDTO>> getAll(){
        List<CityDTO> cities = cityService.getAllCities();
        return ResponseEntity.ok().body(cities);
    }
    @PostMapping
    @ApiOperation("Guardar ciudad")
    public ResponseEntity<CityDTO> save(@RequestBody CityDTO city){
        CityDTO citySaved = cityService.save(city);
        return ResponseEntity.status(HttpStatus.CREATED).body(citySaved);
    }
    @PutMapping("/{id}")
    @ApiOperation("Actualizar ciudad")
    public ResponseEntity<CityDTO> update(@PathVariable Long id, @RequestBody CityDTO city) {
        CityDTO cityUpdated = this.cityService.update(id, city);
        return ResponseEntity.ok().body(cityUpdated);
    }
    @DeleteMapping("/{id}")
    @ApiOperation("Borrar ciudad")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        this.cityService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
