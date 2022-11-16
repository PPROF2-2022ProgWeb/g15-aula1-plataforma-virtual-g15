package com.saberconectar.sc.controller;

import com.saberconectar.sc.dto.CountryDTO;
import com.saberconectar.sc.service.CountryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/countries")
@Api(tags="Paises")
public class CountryController {
    @Autowired
    private CountryService countryService;
    @GetMapping
    @ApiOperation("Listar todos los paises")
    public ResponseEntity<List<CountryDTO>> getAll(){
        List<CountryDTO> countries = countryService.getAllCountries();
        return ResponseEntity.ok().body(countries);
    }
    @PostMapping
    @ApiOperation("Guardar pais")
    public ResponseEntity<CountryDTO> save(@RequestBody CountryDTO country){
        CountryDTO countrySaved = countryService.save(country);
        return ResponseEntity.status(HttpStatus.CREATED).body(countrySaved);
    }
    @PutMapping("/{id}")
    @ApiOperation("Actualizar pais")
    public ResponseEntity<CountryDTO> update(@PathVariable Long id, @RequestBody CountryDTO country) {
        CountryDTO countryUpdated = this.countryService.update(id, country);
        return ResponseEntity.ok().body(countryUpdated);
    }
    @DeleteMapping("/{id}")
    @ApiOperation("Borrar pais")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        this.countryService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
