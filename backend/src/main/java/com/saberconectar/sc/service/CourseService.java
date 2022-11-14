package com.saberconectar.sc.service;

import com.saberconectar.sc.dto.CourseDTO;

import java.util.List;

public interface CourseService{
    CourseDTO save(CourseDTO dto);
    CourseDTO getCourseById(Long id);
    List<CourseDTO> getCourseListByInstitutionId(Long id);
    CourseDTO update(Long id, CourseDTO dto);
    void delete (Long id);
    void isCorrect(Long id, String name);
}
