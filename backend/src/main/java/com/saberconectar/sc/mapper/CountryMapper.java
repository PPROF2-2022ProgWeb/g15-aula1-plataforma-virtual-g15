package com.saberconectar.sc.mapper;

import com.saberconectar.sc.dto.CountryDTO;
import com.saberconectar.sc.entity.CountryEntity;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class CountryMapper {
    public CountryEntity countryDTO2Entity(CountryDTO dto){
        CountryEntity countryEntity = new CountryEntity();
        countryEntity.setName(dto.getName());
        countryEntity.setDeleted(dto.getDeleted());
        return countryEntity;
    }
    public CountryDTO countryEntity2DTO(CountryEntity entity){
        CountryDTO dto = new CountryDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDeleted(entity.getDeleted());
        return dto;
    }
    public List<CountryDTO> countryEntityList2DTOList(List<CountryEntity> entities){
        List<CountryDTO> dtos = new ArrayList<>();
        for (CountryEntity entity: entities){
            dtos.add(countryEntity2DTO(entity));
        }
        return dtos;
    }
    public CountryEntity update(CountryEntity entity, CountryDTO dto){
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDeleted(dto.getDeleted());
        return entity;
    }
}
