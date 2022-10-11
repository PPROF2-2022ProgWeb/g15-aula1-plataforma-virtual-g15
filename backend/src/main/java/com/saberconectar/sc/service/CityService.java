package com.saberconectar.sc.service;

import com.saberconectar.sc.dto.CityDTO;
import java.util.List;
public interface CityService {
    List<CityDTO> getAllCities();
    CityDTO save(CityDTO city);
    CityDTO update(Long id, CityDTO city);
    void delete (Long id);
    void isCorrect(Long id);
}
