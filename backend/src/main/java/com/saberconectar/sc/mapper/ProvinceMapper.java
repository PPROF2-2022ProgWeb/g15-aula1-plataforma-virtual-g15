package com.saberconectar.sc.mapper;

import com.saberconectar.sc.entity.ProvinceEntity;
import com.saberconectar.sc.dto.ProvinceDTO;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class ProvinceMapper {
    public ProvinceEntity provinceDTO2Entity(ProvinceDTO dto){
        ProvinceEntity provinceEntity = new ProvinceEntity();
        provinceEntity.setName(dto.getName());
        provinceEntity.setDeleted(dto.getDeleted());
        return provinceEntity;
    }
    public ProvinceDTO provinceEntity2DTO(ProvinceEntity entity){
        ProvinceDTO dto = new ProvinceDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDeleted(entity.getDeleted());
        return dto;
    }
    public List<ProvinceDTO> provinceEntityList2DTOList(List<ProvinceEntity> entities){
        List<ProvinceDTO> dtos = new ArrayList<>();
        for (ProvinceEntity entity: entities){
            dtos.add(provinceEntity2DTO(entity));
        }
        return dtos;
    }
    public ProvinceEntity update(ProvinceEntity entity, ProvinceDTO dto){
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDeleted(dto.getDeleted());
        return entity;
    }
}
