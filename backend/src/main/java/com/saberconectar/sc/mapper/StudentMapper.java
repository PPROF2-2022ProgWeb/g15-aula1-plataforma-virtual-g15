package com.saberconectar.sc.mapper;

import com.saberconectar.sc.dto.CourseDTO;
import com.saberconectar.sc.dto.InstitutionDTO;
import com.saberconectar.sc.dto.StudentDTO;
import com.saberconectar.sc.dto.UserDTO;
import com.saberconectar.sc.entity.CourseEntity;
import com.saberconectar.sc.entity.InstitutionEntity;
import com.saberconectar.sc.entity.StudentEntity;
import com.saberconectar.sc.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
@Component
public class StudentMapper {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CourseMapper courseMapper;
    public StudentEntity studentDTO2Entity(StudentDTO dto, Boolean loadCourses){
        StudentEntity entity = new StudentEntity();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setDocumentNumber(dto.getDocumentNumber());
        entity.setDate(dto.getDate());
        entity.setDeleted(dto.getDeleted());
        entity.setUserEntity(dto.getUserEntity());
        if(loadCourses){
            entity.setCourses(dto.getCourses());
        }
        return entity;
    }
    public StudentDTO studentEntity2DTO(StudentEntity entity, Boolean loadUser, Boolean loadCourses){
        StudentDTO dto = new StudentDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setDocumentNumber(entity.getDocumentNumber());
        dto.setDate(entity.getDate());
        dto.setDeleted(entity.getDeleted());
        if(loadUser){
            UserDTO userDTO = userMapper.userEntity2DTO(entity.getUserEntity(), false, false);
            UserEntity userEntity = userMapper.userDTO2Entity(userDTO);
            dto.setUserEntity(userEntity);
        }
        if (loadCourses){
            Set<CourseDTO> dtos = courseMapper.courseEntitySet2DTOSet(entity.getCourses(),false, true);
            Set<CourseEntity> entities = courseMapper.courseDTOSet2EntitySet(dtos, true);
            dto.setCourses(entities);
        }

        return dto;
    }
    public StudentEntity update(StudentEntity entity, StudentDTO dto){
        entity.getId();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setDocumentNumber(dto.getDocumentNumber());
        entity.setDate(dto.getDate());
        entity.setDeleted(dto.getDeleted());
        UserDTO userDTO = userMapper.userEntity2DTO(dto.getUserEntity(), false, false);
        UserEntity userEntity = userMapper.update(entity.getUserEntity(), userDTO);
        entity.setUserEntity(userEntity);
        return entity;
    }
    public List<StudentDTO> studentEntityList2DTOList(List<StudentEntity> entities, boolean loadUsers, boolean loadCourses){
        List<StudentDTO> dtos = new ArrayList<>();
        for(StudentEntity entity: entities){
            dtos.add(studentEntity2DTO(entity,loadUsers, loadCourses));
        }
        return dtos;
    }
    public List<StudentEntity> studentDTOList2EntityList(List<StudentDTO> dtos, boolean loadCourses){
        List<StudentEntity> entities = new ArrayList<>();
        for(StudentDTO dto: dtos){
            entities.add(studentDTO2Entity(dto, loadCourses));
        }
        return entities;
    }
}
