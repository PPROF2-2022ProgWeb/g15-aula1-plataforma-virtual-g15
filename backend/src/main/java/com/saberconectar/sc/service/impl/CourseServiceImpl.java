package com.saberconectar.sc.service.impl;

import com.saberconectar.sc.dto.CourseDTO;
import com.saberconectar.sc.entity.CourseEntity;
import com.saberconectar.sc.exception.ParamNotFound;
import com.saberconectar.sc.mapper.CourseMapper;
import com.saberconectar.sc.repository.CourseRepository;
import com.saberconectar.sc.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private CourseMapper courseMapper;
    public CourseDTO save(CourseDTO dto) {
        CourseEntity entity = courseMapper.courseDTO2Entity(dto, false);
        CourseEntity entitySaved = courseRepository.save(entity);
        CourseDTO course = courseMapper.courseEntity2DTO(entitySaved, false);
        return course;
    }
    public CourseDTO getCourseById(Long id) {
        isCorrect(id, "id");
        CourseEntity entity = courseRepository.getReferenceById(id);
        CourseDTO dto = courseMapper.courseEntity2DTO(entity, true);
        return dto;
    }
    public CourseDTO update(Long id, CourseDTO dto){
        isCorrect(id, "id");
        CourseEntity entityId = courseRepository.getReferenceById(id);
        CourseEntity entity = courseMapper.update(entityId,dto);
        CourseEntity entityUpdated = courseRepository.save(entity);
        CourseDTO result = courseMapper.courseEntity2DTO(entityUpdated, false);
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
