package com.saberconectar.sc.controller;

import com.saberconectar.sc.dto.CityDTO;
import com.saberconectar.sc.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cities")
public class CityController {
    @Autowired
    private CityService cityService;
    @GetMapping
    public ResponseEntity<List<CityDTO>> getAll(){
        List<CityDTO> cities = cityService.getAllCities();
        return ResponseEntity.ok().body(cities);
    }
    @PostMapping
    public ResponseEntity<CityDTO> save(@RequestBody CityDTO city){
        CityDTO citySaved = cityService.save(city);
        return ResponseEntity.status(HttpStatus.CREATED).body(citySaved);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CityDTO> update(@PathVariable Long id, @RequestBody CityDTO city) {
        CityDTO cityUpdated = this.cityService.update(id, city);
        return ResponseEntity.ok().body(cityUpdated);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        this.cityService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
