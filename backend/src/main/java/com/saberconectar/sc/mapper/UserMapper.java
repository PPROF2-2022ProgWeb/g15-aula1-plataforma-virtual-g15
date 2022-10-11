package com.saberconectar.sc.mapper;

import com.saberconectar.sc.dto.UserDTO;
import com.saberconectar.sc.entity.UserEntity;
import org.springframework.stereotype.Component;
@Component
public class UserMapper {
    public UserEntity userDTO2Entity(UserDTO dto){
        UserEntity entity = new UserEntity();
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        entity.setDeleted(dto.getDeleted());
        entity.setCountryId(dto.getCountryId());
        entity.setProvinceId(dto.getProvinceId());
        entity.setCityId(dto.getCityId());
        return entity;
    }
    public UserDTO userEntity2DTO(UserEntity entity, Boolean setStudent, Boolean setInstitution){
        UserDTO dto = new UserDTO();
        dto.setId(entity.getId());
        dto.setEmail(entity.getEmail());
        dto.setPassword(entity.getPassword());
        dto.setDeleted(entity.getDeleted());
        dto.setCountryId(entity.getCountryId());
        dto.setProvinceId(entity.getProvinceId());
        dto.setCityId(entity.getCityId());
        if(setStudent){
            dto.setStudentEntity(entity.getStudentEntity());
        }
        if(setInstitution){
            dto.setInstitutionEntity(entity.getInstitutionEntity());
        }
        return dto;
    }
    public UserEntity update(UserEntity entity, UserDTO dto){
        entity.getId();
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        entity.setDeleted(dto.getDeleted());
        entity.setCountryId(dto.getCountryId());
        entity.setProvinceId(dto.getProvinceId());
        entity.setCityId(dto.getCityId());
        return entity;
    }
}
