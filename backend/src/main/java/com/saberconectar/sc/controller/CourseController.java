package com.saberconectar.sc.controller;

import com.saberconectar.sc.dto.CourseDTO;
import com.saberconectar.sc.dto.CourseListDTO;
import com.saberconectar.sc.repository.CourseRepository;
import com.saberconectar.sc.service.CourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
@CrossOrigin(origins = "http://localhost:4200")
@Api(tags="Cursos")
public class CourseController {
    @Autowired
    private CourseRepository repository;
    @Autowired
    private CourseService courseService;

    @GetMapping("/all")
    @ApiOperation("Listar todos  los cursos")
    public ResponseEntity<List<CourseListDTO>> listAllCourses(){
        return ResponseEntity.status(HttpStatus.CREATED).body(courseService.getAllCourses());
    }
    @GetMapping("/all/{institutionId}")
    @ApiOperation("Listar todos  los cursos por institución")
    public ResponseEntity<List<CourseDTO>> listAllCoursesByInstitutionId(@PathVariable Long institutionId){
        return ResponseEntity.status(HttpStatus.CREATED).body(courseService.getCourseListByInstitutionId(institutionId));
    }
    @PostMapping()
    @ApiOperation("Crear curso")
    public ResponseEntity<CourseDTO> createCourse(@RequestBody CourseDTO dto)
    {
        CourseDTO courseSaved = courseService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(courseSaved);
    }
    @GetMapping("/{id}")
    @ApiOperation("Mostrar curso por id")
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable Long id)
    {
        CourseDTO dto = courseService.getCourseById(id);
        return ResponseEntity.ok().body(dto);
    }
    @PutMapping("/{id}")
    @ApiOperation("Actualizar curso")
    public ResponseEntity<CourseDTO> update(@PathVariable Long id, @RequestBody CourseDTO dto) {
        CourseDTO courseUpdated = courseService.update(id, dto);
        return ResponseEntity.ok().body(courseUpdated);
    }
    @DeleteMapping("/{id}")
    @ApiOperation("Borrar curso")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        this.courseService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
