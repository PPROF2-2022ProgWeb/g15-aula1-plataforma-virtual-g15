package com.saberconectar.sc.service.impl;

import com.saberconectar.sc.dto.InstitutionDTO;
import com.saberconectar.sc.entity.CourseEntity;
import com.saberconectar.sc.entity.InstitutionEntity;
import com.saberconectar.sc.exception.ParamNotFound;
import com.saberconectar.sc.mapper.InstitutionMapper;
import com.saberconectar.sc.repository.CourseRepository;
import com.saberconectar.sc.repository.InstitutionRepository;
import com.saberconectar.sc.service.InstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class InstitutionServiceImpl implements InstitutionService {
    @Autowired
    private InstitutionRepository institutionRepository;
    @Autowired
    private InstitutionMapper institutionMapper;
    @Autowired
    private CourseRepository courseRepository;
    public InstitutionDTO institutionRegister(InstitutionDTO dto) {
        InstitutionEntity entity = institutionMapper.institutionDTO2Entity(dto, false);
        InstitutionEntity entitySaved = institutionRepository.save(entity);
        InstitutionDTO result = institutionMapper.institutionEntity2DTO(entitySaved,true, true);
        return result;
    }
    public void delete(Long id) {
        isCorrect(id, "id");
        this.institutionRepository.deleteById(id);
    }
    public InstitutionDTO getInstitutionById(Long id) {
        isCorrect(id, "id");
        InstitutionEntity entity = institutionRepository.getReferenceById(id);
        InstitutionDTO dto = institutionMapper.institutionEntity2DTO(entity,true, false);
        return dto;
    }
    public InstitutionDTO getInstitutionCoursesById(Long id) {
        isCorrect(id, "id");
        InstitutionEntity entity = institutionRepository.getReferenceById(id);
        InstitutionDTO dto = institutionMapper.institutionEntity2DTO(entity,
                false, true);
        return dto;
    }
    public InstitutionDTO update(Long id, InstitutionDTO institution) {
        isCorrect(id, "id");
        InstitutionEntity entityId = institutionRepository.getReferenceById(id);
        InstitutionEntity entity = institutionMapper.update(entityId, institution);
        InstitutionEntity entityUpdated = institutionRepository.save(entity);
        InstitutionDTO dto = institutionMapper.institutionEntity2DTO(entityUpdated,true, false);
        return dto;
    }
    public void addCourse(Long idInstitution, Long idCourse) {
        areCorrect(idInstitution, "institution id", idCourse, "course id");
        InstitutionEntity institutionEntity = institutionRepository.getReferenceById(idInstitution);
        CourseEntity courseEntity = courseRepository.getReferenceById(idCourse);
        institutionEntity.getCourses().add(courseEntity);
        institutionRepository.save(institutionEntity);
    }
    public void removeCourse(Long idInstitution, Long idCourse) {
        areCorrect(idInstitution, "institution id.", idCourse, "course id.");
        InstitutionEntity institutionEntity = institutionRepository.getReferenceById(idInstitution);
        CourseEntity courseEntity = courseRepository.getReferenceById(idCourse);
        institutionEntity.getCourses().remove(courseEntity);
        institutionRepository.save(institutionEntity);
    }
    public void isCorrect(Long id, String name){
        if(!institutionRepository.existsById(id)){
            throw new ParamNotFound("Invalid " + name);
        }
    }
    public void areCorrect(Long idOne, String nameOne, Long idTwo, String nameTwo) {
        if (!institutionRepository.existsById(idOne)&&!courseRepository.existsById(idTwo)){
            throw new ParamNotFound("Invalid items");
        }else{
            isCorrect(idOne, nameOne);
            if (!courseRepository.existsById(idTwo)){
                throw new ParamNotFound("Invalid " + nameTwo );
            }
        }
    }
}
