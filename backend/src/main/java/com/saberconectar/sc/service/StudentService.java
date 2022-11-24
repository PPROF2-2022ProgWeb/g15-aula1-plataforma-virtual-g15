package com.saberconectar.sc.service;

import com.saberconectar.sc.dto.CourseDTO;
import com.saberconectar.sc.dto.StudentDTO;

import java.util.List;

public interface StudentService {
    StudentDTO studentRegister(StudentDTO dto) throws Exception;
    StudentDTO getStudentById(Long id);
    List<CourseDTO> getStudentANDCoursesById(Long id);
    StudentDTO update(Long id, StudentDTO dto);
    void addCourse(Long idStudent, Long idCourse);
    void removeCourse(Long idStudent, Long idCourse);
    void delete(Long id);
    void isCorrect(Long id, String name);
    void areCorrect(Long idOne, String nameOne, Long idTwo, String nameTwo);
}
