package com.saberconectar.sc.controller;

import com.saberconectar.sc.dto.CourseDTO;
import com.saberconectar.sc.dto.StudentDTO;
import com.saberconectar.sc.entity.StudentEntity;
import com.saberconectar.sc.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
@RestController
@RequestMapping("/students")
@Api(tags="Estudiantes")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping("/{id}")
    @ApiOperation("Mostrar estudiante por id")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable Long id){
        StudentDTO student = studentService.getStudentById(id);
        return ResponseEntity.ok().body(student);
    }
    @GetMapping("/{id}/courses")
    @ApiOperation("Mostrar estudiante y curso por id")
    public ResponseEntity<List<CourseDTO>> getStudentANDCoursesById(@PathVariable Long id){
        List<CourseDTO> courses = studentService.getStudentANDCoursesById(id);
        return ResponseEntity.ok().body(courses);
    }
    @DeleteMapping("/{id}")
    @ApiOperation("Borrar estudiante")
    public ResponseEntity<Void> studentDelete(@PathVariable Long id){
        this.studentService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PutMapping("/{id}")
    @ApiOperation("Actualizar estudiante")
    public ResponseEntity<StudentDTO> studentUpdate(@PathVariable Long id, @RequestBody StudentDTO dto){
        StudentDTO dtoUpdated = studentService.update(id, dto);
        return ResponseEntity.ok().body(dtoUpdated);
    }
    @PostMapping
    @ApiOperation("Registrar estudiante")
    public ResponseEntity<StudentDTO> studentRegister(@RequestBody StudentDTO dto){
        StudentDTO studentSaved = studentService.studentRegister(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(studentSaved);
    }
    //Add student-course relationship
    @PostMapping("/{idStudent}/courses/{idCourse}")
    @ApiOperation("Agregar curso a estudiante")
    public ResponseEntity<Set<StudentEntity>>
    inscribeCourse(@PathVariable Long idStudent, @PathVariable Long idCourse)
    {
        studentService.addCourse(idStudent, idCourse);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    //remove student-course relationship
    @DeleteMapping("/{idStudent}/courses/{idCourse}")
    @ApiOperation("Remover curso a estudiante")
    public ResponseEntity<StudentEntity>
    uninscribeCourse(@PathVariable Long idStudent, @PathVariable Long idCourse)
    {
        studentService.removeCourse(idStudent, idCourse);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
