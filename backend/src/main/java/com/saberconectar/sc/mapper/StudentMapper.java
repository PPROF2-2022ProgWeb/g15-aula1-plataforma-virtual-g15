package com.saberconectar.sc.mapper;

import com.saberconectar.sc.dto.CourseDTO;
import com.saberconectar.sc.dto.StudentDTO;
import com.saberconectar.sc.dto.UserDTO;
import com.saberconectar.sc.entity.CourseEntity;
import com.saberconectar.sc.entity.StudentEntity;
import com.saberconectar.sc.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Set;
@Component
public class StudentMapper {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CourseMapper courseMapper;
    public StudentEntity studentDTO2Entity(StudentDTO dto){
        StudentEntity entity = new StudentEntity();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setDocumentNumber(dto.getDocumentNumber());
        entity.setDate(dto.getDate());
        entity.setDeleted(dto.getDeleted());
        entity.setUserEntity(dto.getUserEntity());
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
            Set<CourseDTO> dtos = courseMapper.courseEntitySet2DTOSet(entity.getCourses(), false);
            Set<CourseEntity> entities = courseMapper.courseDTOSet2EntitySet(dtos, false);
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
}
