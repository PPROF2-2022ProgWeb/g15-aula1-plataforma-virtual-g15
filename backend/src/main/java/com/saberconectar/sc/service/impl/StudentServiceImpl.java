package com.saberconectar.sc.service.impl;

import com.saberconectar.sc.dto.StudentDTO;
import com.saberconectar.sc.entity.CourseEntity;
import com.saberconectar.sc.entity.StudentEntity;
import com.saberconectar.sc.exception.ParamNotFound;
import com.saberconectar.sc.mapper.StudentMapper;
import com.saberconectar.sc.repository.CourseRepository;
import com.saberconectar.sc.repository.StudentRepository;
import com.saberconectar.sc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentMapper studentMapper;
    public StudentDTO studentRegister(StudentDTO dto) {
        StudentEntity entity = studentMapper.studentDTO2Entity(dto);
        StudentEntity entitySaved = studentRepository.save(entity);
        StudentDTO result = studentMapper.studentEntity2DTO(entitySaved,
                true, false);
        return result;
    }
    public void delete(Long id) {
        isCorrect(id, "id");
        this.studentRepository.deleteById(id);
    }
    public StudentDTO getStudentById(Long id) {
        isCorrect(id, "id");
        StudentEntity entity = studentRepository.getReferenceById(id);
        StudentDTO dto = studentMapper.studentEntity2DTO(entity,
                true ,false);
        return dto;
    }
    public StudentDTO getStudentANDCoursesById(Long id) {
        isCorrect(id, "id");
        StudentEntity entity = studentRepository.getReferenceById(id);
        StudentDTO dto = studentMapper.studentEntity2DTO(entity,
                false, true);
        return dto;
    }
    public StudentDTO update(Long id, StudentDTO student) {
        isCorrect(id, "id");
        StudentEntity entityId = studentRepository.getReferenceById(id);
        StudentEntity entity = studentMapper.update(entityId, student);
        StudentEntity entityUpdated = studentRepository.save(entity);
        StudentDTO dto = studentMapper.studentEntity2DTO(entityUpdated,
                true, false);
        return dto;
    }
    public void addCourse(Long idStudent, Long idCourse) {
        areCorrect(idStudent, "student id.", idCourse, "course id.");
        StudentEntity studentEntity = studentRepository.getReferenceById(idStudent);
        CourseEntity courseEntity = courseRepository.getReferenceById(idCourse);
        studentEntity.getCourses().add(courseEntity);
        studentRepository.save(studentEntity);
    }
    public void removeCourse(Long idStudent, Long idCourse) {
        areCorrect(idStudent, "student id.", idCourse, "course id.");
        StudentEntity studentEntity = studentRepository.getReferenceById(idStudent);
        CourseEntity courseEntity = courseRepository.getReferenceById(idCourse);
        studentEntity.getCourses().remove(courseEntity);
        studentRepository.save(studentEntity);
    }
    public void isCorrect(Long id, String name){
        if(!studentRepository.existsById(id)){
            throw new ParamNotFound("Invalid id");
        }
    }
    public void areCorrect(Long idOne, String nameOne, Long idTwo, String nameTwo) {
        if (!studentRepository.existsById(idOne)&&!courseRepository.existsById(idTwo)){
            throw new ParamNotFound("Invalid items");
        }else{
            isCorrect(idOne, nameOne);
            if (!courseRepository.existsById(idTwo)){
                throw new ParamNotFound("Invalid " + nameTwo );
            }
        }
    }
}
