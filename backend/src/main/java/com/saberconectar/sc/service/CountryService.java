package com.saberconectar.sc.service;

import com.saberconectar.sc.dto.CountryDTO;
import java.util.List;
public interface CountryService {
    List<CountryDTO> getAllCountries();
    CountryDTO save(CountryDTO country);
    CountryDTO update(Long id, CountryDTO country);
    void delete (Long id);
    void isCorrect(Long id);
}
