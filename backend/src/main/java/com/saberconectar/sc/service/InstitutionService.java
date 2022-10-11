package com.saberconectar.sc.service;

import com.saberconectar.sc.dto.InstitutionDTO;
public interface InstitutionService {
    InstitutionDTO getInstitutionById(Long id);
    InstitutionDTO getInstitutionCoursesById(Long id);
    InstitutionDTO institutionRegister(InstitutionDTO dto);
    InstitutionDTO update(Long id, InstitutionDTO dto);
    void addCourse(Long idInstitution, Long idCourse);
    void removeCourse(Long idInstitution, Long idCourse);
    void delete(Long id);
    void isCorrect(Long id, String name);
    void areCorrect(Long idOne, String nameOne, Long idTwo, String nameTwo);
}
