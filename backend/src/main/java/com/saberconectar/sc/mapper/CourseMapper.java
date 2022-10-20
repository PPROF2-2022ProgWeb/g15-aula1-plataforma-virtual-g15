package com.saberconectar.sc.mapper;

import com.saberconectar.sc.dto.CourseDTO;
import com.saberconectar.sc.dto.InstitutionDTO;
import com.saberconectar.sc.dto.StudentDTO;
import com.saberconectar.sc.entity.CourseEntity;
import com.saberconectar.sc.entity.InstitutionEntity;
import com.saberconectar.sc.entity.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.*;


@Component
public class CourseMapper {
    @Autowired
    private InstitutionMapper institutionMapper;
    @Autowired
    private StudentMapper studentMapper;
    public CourseEntity courseDTO2Entity(CourseDTO dto, boolean loadInstitutions){
        CourseEntity entity = new CourseEntity();
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setBeginningDay(dto.getBeginningDay());
        entity.setEndingDay(dto.getEndingDay());
        if(loadInstitutions){
            entity.setInstitutions(dto.getInstitutions());
        }
        return entity;
    }
    public CourseDTO courseEntity2DTO(CourseEntity entity,Boolean loadStudents, Boolean loadInstitutions){
        CourseDTO dto = new CourseDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setBeginningDay(entity.getBeginningDay());
        dto.setEndingDay(entity.getEndingDay());
        dto.setDeleted(entity.getDeleted());
        if(loadInstitutions){
            List<InstitutionDTO> dtos = institutionMapper.institutionEntityList2DTOList(entity.getInstitutions(),false, false);
            List<InstitutionEntity> entities = institutionMapper.institutionDTOList2EntityList(dtos, false);
            dto.setInstitutions(entities);
        }
        if(loadStudents){
            List<StudentDTO> dtos = studentMapper.studentEntityList2DTOList(entity.getStudents(),false, false);
            List<StudentEntity> entities = studentMapper.studentDTOList2EntityList(dtos, false);
            dto.setStudents(entities);
        }
        return dto;
    }
    public CourseEntity update(CourseEntity entity, CourseDTO dto){
        entity.getId();
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setBeginningDay(dto.getBeginningDay());
        entity.setEndingDay(dto.getEndingDay());
        entity.setDeleted(dto.getDeleted());
        entity.getInstitutions();
        return entity;
    }
    public Set<CourseDTO> courseEntitySet2DTOSet(Collection<CourseEntity> entities,boolean loadStudents, boolean loadInstitution){
        Set<CourseDTO> dtos = new HashSet<>();
        for (CourseEntity entity: entities){
            dtos.add(courseEntity2DTO(entity,loadStudents, loadInstitution));
        }
        return dtos;
    }
    public Set<CourseEntity> courseDTOSet2EntitySet(Collection<CourseDTO> dtos, boolean loadInstitution){
        Set<CourseEntity> entities = new HashSet<>();
        for (CourseDTO dto: dtos){
            entities.add(this.courseDTO2Entity(dto, loadInstitution));
        }
        return entities;
    }
}