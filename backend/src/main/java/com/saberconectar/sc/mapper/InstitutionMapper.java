package com.saberconectar.sc.mapper;

import com.saberconectar.sc.dto.CourseDTO;
import com.saberconectar.sc.dto.InstitutionDTO;
import com.saberconectar.sc.dto.UserDTO;
import com.saberconectar.sc.entity.CourseEntity;
import com.saberconectar.sc.entity.InstitutionEntity;
import com.saberconectar.sc.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Component
public class InstitutionMapper {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CourseMapper courseMapper;
    public InstitutionEntity institutionDTO2Entity(InstitutionDTO dto, Boolean loadCourses){
        InstitutionEntity entity = new InstitutionEntity();
        entity.setName(dto.getName());
        entity.setCuitNumber(dto.getCuitNumber());
        entity.setDeleted(dto.getDeleted());
        entity.setUserEntity(dto.getUserEntity());
        if(loadCourses){
            entity.setCourses(dto.getCourses());
        }
        return entity;
    }
    public InstitutionDTO institutionEntity2DTO(InstitutionEntity entity,Boolean loadUser, Boolean loadCourses){
        InstitutionDTO dto = new InstitutionDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCuitNumber(entity.getCuitNumber());
        dto.setDeleted(entity.getDeleted());
        if(loadUser){
            UserDTO userDTO = userMapper.userEntity2DTO(entity.getUserEntity(), false, false);
            UserEntity userEntity = userMapper.userDTO2Entity(userDTO);
            dto.setUserEntity(userEntity);
        }
        if (loadCourses){
            Set<CourseDTO> dtos = courseMapper.courseEntitySet2DTOSet(entity.getCourses(), false);
            Set<CourseEntity> entities = courseMapper.courseDTOSet2EntitySet(dtos, false);
            dto.setCourses(entities);
        }
        return dto;
    }
    public InstitutionEntity update(InstitutionEntity entity, InstitutionDTO dto){
        entity.getId();
        entity.setName(dto.getName());
        entity.setCuitNumber(dto.getCuitNumber());
        entity.setDeleted(dto.getDeleted());
        UserDTO userDTO = userMapper.userEntity2DTO(dto.getUserEntity(), false, false);
        UserEntity userEntity = userMapper.update(entity.getUserEntity(), userDTO);
        entity.setUserEntity(userEntity);
        return entity;
    }
    public List<InstitutionDTO> institutionEntityList2DTOList(List<InstitutionEntity> entities,boolean loadUsers, boolean loadCourses){
        List<InstitutionDTO> dtos = new ArrayList<>();
        for(InstitutionEntity entity: entities){
            dtos.add(this.institutionEntity2DTO(entity,loadUsers, loadCourses));
        }
        return dtos;
    }
    public List<InstitutionEntity> institutionDTOList2EntityList(List<InstitutionDTO> dtos, boolean loadCourses){
        List<InstitutionEntity> entities = new ArrayList<>();
        for(InstitutionDTO dto: dtos){
            entities.add(institutionDTO2Entity(dto, loadCourses));
        }
        return entities;
    }
}
