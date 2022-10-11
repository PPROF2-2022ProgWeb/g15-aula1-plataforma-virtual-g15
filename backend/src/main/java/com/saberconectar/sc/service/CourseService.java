package com.saberconectar.sc.service;

import com.saberconectar.sc.dto.CourseDTO;
public interface CourseService{
    CourseDTO save(CourseDTO dto);
    CourseDTO getCourseById(Long id);
    CourseDTO update(Long id, CourseDTO dto);
    void delete (Long id);
    void isCorrect(Long id, String name);
}
