package com.saberconectar.sc.service.impl;

import com.saberconectar.sc.dto.CountryDTO;
import com.saberconectar.sc.entity.CountryEntity;
import com.saberconectar.sc.exception.ParamNotFound;
import com.saberconectar.sc.mapper.CountryMapper;
import com.saberconectar.sc.repository.CountryRepository;
import com.saberconectar.sc.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private CountryMapper countryMapper;
    @Override
    public List<CountryDTO> getAllCountries() {
        List<CountryEntity> entities = countryRepository.findAll();
        List<CountryDTO> dtos = countryMapper.countryEntityList2DTOList(entities);
        return dtos;
    }
    @Override
    public CountryDTO save(CountryDTO dto) {
        CountryEntity entity = countryMapper.countryDTO2Entity(dto);
        CountryEntity entitySaved = countryRepository.save(entity);
        CountryDTO result = countryMapper.countryEntity2DTO(entitySaved);
        return result;
    }
    public CountryDTO update(Long id, CountryDTO country){
        isCorrect(id);
        CountryEntity entityId = countryRepository.getReferenceById(id);
        CountryEntity entity = countryMapper.update(entityId,country);
        CountryEntity entityUpdated = countryRepository.save(entity);
        CountryDTO result = countryMapper.countryEntity2DTO(entityUpdated);
        return result;
    }
    @Override
    public void delete(Long id) {
        isCorrect(id);
        this.countryRepository.deleteById(id);
    }
    public void isCorrect(Long id){
        if(!countryRepository.existsById(id)){
            throw new ParamNotFound("Invalid id");
        }
    }
}
