package com.saberconectar.sc.service;

import com.saberconectar.sc.dto.StudentDTO;
public interface StudentService {
    StudentDTO studentRegister(StudentDTO dto);
    StudentDTO getStudentById(Long id);
    StudentDTO getStudentANDCoursesById(Long id);
    StudentDTO update(Long id, StudentDTO dto);
    void addCourse(Long idStudent, Long idCourse);
    void removeCourse(Long idStudent, Long idCourse);
    void delete(Long id);
    void isCorrect(Long id, String name);
    void areCorrect(Long idOne, String nameOne, Long idTwo, String nameTwo);
}
