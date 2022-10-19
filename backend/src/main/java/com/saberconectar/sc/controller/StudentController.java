package com.saberconectar.sc.controller;

import com.saberconectar.sc.dto.StudentDTO;
import com.saberconectar.sc.entity.StudentEntity;
import com.saberconectar.sc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Set;
@RestController
@RequestMapping("students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable Long id){
        StudentDTO student = studentService.getStudentById(id);
        return ResponseEntity.ok().body(student);
    }
    @GetMapping("/{id}/courses")
    public ResponseEntity<StudentDTO> getStudentANDCoursesById(@PathVariable Long id){
        StudentDTO student = studentService.getStudentANDCoursesById(id);
        return ResponseEntity.ok().body(student);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> studentDelete(@PathVariable Long id){
        this.studentService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> studentUpdate(@PathVariable Long id, @RequestBody StudentDTO dto){
        StudentDTO dtoUpdated = studentService.update(id, dto);
        return ResponseEntity.ok().body(dtoUpdated);
    }
    @PostMapping
    public ResponseEntity<StudentDTO> studentRegister(@RequestBody StudentDTO dto){
        StudentDTO studentSaved = studentService.studentRegister(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(studentSaved);
    }
    //Add student-course relationship
    @PostMapping("/{idStudent}/courses/{idCourse}")
    public ResponseEntity<Set<StudentEntity>>
    inscribeCourse(@PathVariable Long idStudent, @PathVariable Long idCourse)
    {
        studentService.addCourse(idStudent, idCourse);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    //remove student-course relationship
    @DeleteMapping("/{idStudent}/courses/{idCourse}")
    public ResponseEntity<StudentEntity>
    uninscribeCourse(@PathVariable Long idStudent, @PathVariable Long idCourse)
    {
        studentService.removeCourse(idStudent, idCourse);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
