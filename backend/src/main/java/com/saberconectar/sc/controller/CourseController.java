package com.saberconectar.sc.controller;

import com.saberconectar.sc.dto.CourseDTO;
import com.saberconectar.sc.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("courses")
public class CourseController {
    @Autowired
    private CourseService courseService;
    @PostMapping
    public ResponseEntity<CourseDTO> createCourse(@RequestBody CourseDTO dto)
    {
        CourseDTO courseSaved = courseService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(courseSaved);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable Long id)
    {
        CourseDTO dto = courseService.getCourseById(id);
        return ResponseEntity.ok().body(dto);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CourseDTO> update(@PathVariable Long id, @RequestBody CourseDTO dto) {
        CourseDTO courseUpdated = courseService.update(id, dto);
        return ResponseEntity.ok().body(courseUpdated);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        this.courseService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
