package com.saberconectar.sc.mapper;

import com.saberconectar.sc.entity.CityEntity;
import com.saberconectar.sc.dto.CityDTO;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class CityMapper {
    public CityEntity cityDTO2Entity(CityDTO dto){
        CityEntity cityEntity = new CityEntity();
        cityEntity.setName(dto.getName());
        cityEntity.setDeleted(dto.getDeleted());
        return cityEntity;
    }
    public CityDTO cityEntity2DTO(CityEntity entity){
        CityDTO dto = new CityDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDeleted(entity.getDeleted());
        return dto;
    }
    public List<CityDTO> cityEntityList2DTOList(List<CityEntity> entities){
        List<CityDTO> dtos = new ArrayList<>();
        for (CityEntity entity: entities){
            dtos.add(cityEntity2DTO(entity));
        }
        return dtos;
    }
    public CityEntity update(CityEntity entity, CityDTO dto){
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDeleted(dto.getDeleted());
        return entity;
    }
}
