package com.saberconectar.sc.service.impl;

import com.saberconectar.sc.dto.CourseDTO;
import com.saberconectar.sc.dto.CourseListDTO;
import com.saberconectar.sc.entity.CourseEntity;
import com.saberconectar.sc.exception.ParamNotFound;
import com.saberconectar.sc.mapper.CourseMapper;
import com.saberconectar.sc.repository.CourseRepository;
import com.saberconectar.sc.repository.InstitutionRepository;
import com.saberconectar.sc.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private InstitutionRepository institutionRepository;
    @Autowired
    private CourseMapper courseMapper;
    public CourseDTO save(CourseDTO dto) {
        CourseEntity entity = courseMapper.courseDTO2Entity(dto, false);
        CourseEntity entitySaved = courseRepository.save(entity);
        CourseEntity loadEntitySaved = courseRepository.getReferenceById(entitySaved.getId());
        CourseDTO course = courseMapper.courseEntity2DTO(loadEntitySaved,false, false);
        return course;
    }
    public CourseDTO getCourseById(Long id) {
        isCorrect(id, "id");
        CourseEntity entity = courseRepository.getReferenceById(id);
        CourseDTO dto = courseMapper.courseEntity2DTO(entity, false,false);
        return dto;
    }
    public List<CourseListDTO> getAllCourses(){
        List<CourseEntity> entities = courseRepository.findAll();
        List<CourseListDTO> dtosMapped = courseMapper.courseEntityList2DTOList(entities,false,true);
        return dtosMapped;
    }
    public List<CourseDTO> getCourseListByInstitutionId(Long id){
        Set<CourseEntity> setCourses = institutionRepository.getReferenceById(id).getCourses();
        ArrayList<CourseDTO> lista = courseMapper.courseEntitySet2DTOArray(setCourses,false,false);
        return lista;
    }
    public CourseDTO update(Long id, CourseDTO dto){
        isCorrect(id, "id");
        CourseEntity entityId = courseRepository.getReferenceById(id);
        CourseEntity entity = courseMapper.update(entityId,dto);
        CourseEntity entityUpdated = courseRepository.save(entity);
        CourseDTO result = courseMapper.courseEntity2DTO(entityUpdated,false, false);
        return result;
    }
    public void delete(Long id) {
        isCorrect(id, "id");
        this.courseRepository.deleteById(id);
    }
    public void isCorrect(Long id, String name){
        if(!courseRepository.existsById(id)){
            throw new ParamNotFound("Invalid " + name);
        }
    }
}
