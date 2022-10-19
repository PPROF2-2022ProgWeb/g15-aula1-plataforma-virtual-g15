package com.saberconectar.sc.controller;

import com.saberconectar.sc.dto.CountryDTO;
import com.saberconectar.sc.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("countries")
public class CountryController {
    @Autowired
    private CountryService countryService;
    @GetMapping
    public ResponseEntity<List<CountryDTO>> getAll(){
        List<CountryDTO> countries = countryService.getAllCountries();
        return ResponseEntity.ok().body(countries);
    }
    @PostMapping
    public ResponseEntity<CountryDTO> save(@RequestBody CountryDTO country){
        CountryDTO countrySaved = countryService.save(country);
        return ResponseEntity.status(HttpStatus.CREATED).body(countrySaved);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CountryDTO> update(@PathVariable Long id, @RequestBody CountryDTO country) {
        CountryDTO countryUpdated = this.countryService.update(id, country);
        return ResponseEntity.ok().body(countryUpdated);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        this.countryService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
