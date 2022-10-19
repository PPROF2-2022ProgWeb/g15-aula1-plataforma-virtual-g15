package com.saberconectar.sc.service;

import com.saberconectar.sc.dto.ProvinceDTO;
import java.util.List;
public interface ProvinceService {
    List<ProvinceDTO> getAllProvinces();
    ProvinceDTO save(ProvinceDTO province);
    ProvinceDTO update(Long id, ProvinceDTO province);
    void delete (Long id);
    void isCorrect(Long id);
}
