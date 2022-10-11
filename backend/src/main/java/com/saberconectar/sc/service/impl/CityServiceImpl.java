package com.saberconectar.sc.service.impl;

import com.saberconectar.sc.entity.CityEntity;
import com.saberconectar.sc.exception.ParamNotFound;
import com.saberconectar.sc.dto.CityDTO;
import com.saberconectar.sc.mapper.CityMapper;
import com.saberconectar.sc.repository.CityRepository;
import com.saberconectar.sc.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private CityMapper cityMapper;

    @Override
    public List<CityDTO> getAllCities() {
        List<CityEntity> entities = cityRepository.findAll();
        List<CityDTO> dtos = cityMapper.cityEntityList2DTOList(entities);
        return dtos;
    }

    @Override
    public CityDTO save(CityDTO dto) {
        CityEntity entity = cityMapper.cityDTO2Entity(dto);
        CityEntity entitySaved = cityRepository.save(entity);
        CityDTO result = cityMapper.cityEntity2DTO(entitySaved);
        return result;
    }

    public CityDTO update(Long id, CityDTO city){
        isCorrect(id);
        CityEntity entityId = cityRepository.getReferenceById(id);
        CityEntity entity = cityMapper.update(entityId,city);
        CityEntity entityUpdated = cityRepository.save(entity);
        CityDTO result = cityMapper.cityEntity2DTO(entityUpdated);
        return result;
    }
    @Override
    public void delete(Long id) {
        isCorrect(id);
        this.cityRepository.deleteById(id);
    }
    public void isCorrect(Long id){
        if(!cityRepository.existsById(id)){
            throw new ParamNotFound("Invalid id");
        }
    }
}
