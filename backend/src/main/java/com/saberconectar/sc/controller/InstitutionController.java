package com.saberconectar.sc.controller;

import com.saberconectar.sc.dto.CourseDTO;
import com.saberconectar.sc.dto.InstitutionDTO;
import com.saberconectar.sc.entity.InstitutionEntity;
import com.saberconectar.sc.service.CourseService;
import com.saberconectar.sc.service.InstitutionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/institutions")
@Api(tags="Instituciones")
public class InstitutionController {
    @Autowired
    private InstitutionService institutionService;
    @Autowired
    private CourseController courseController;
    @Autowired
    private CourseService courseService;
    @GetMapping("/{id}")
    @ApiOperation("Mostrar institución por id")
    public ResponseEntity<InstitutionDTO> getInstitutionById(@PathVariable Long id)
    {
        InstitutionDTO institution = institutionService.getInstitutionById(id);
        return ResponseEntity.ok().body(institution);
    }
    /*
    @GetMapping("/{id}/courses")
    public ResponseEntity<InstitutionDTO> getInstitutionCoursesById(@PathVariable Long id){
        InstitutionDTO institution = institutionService.getInstitutionCoursesById(id);
        return ResponseEntity.ok().body(institution);
    }*/
    @PostMapping
    @ApiOperation("Registrar institución")
    public ResponseEntity<InstitutionDTO> institutionRegister(@RequestBody InstitutionDTO dto)
    {
        InstitutionDTO institutionSaved = institutionService.institutionRegister(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(institutionSaved);
    }
    @DeleteMapping("/{id}")
    @ApiOperation("Borrar institución")
    public ResponseEntity<Void> institutionDelete(@PathVariable Long id)
    {
        institutionService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PutMapping("/{id}")
    @ApiOperation("Actualizar institución")
    public ResponseEntity<InstitutionDTO>
    institutionUpdate(@PathVariable Long id, @RequestBody InstitutionDTO dto)
    {
        InstitutionDTO dtoUpdated = institutionService.update(id, dto);
        return ResponseEntity.ok().body(dtoUpdated);
    }
    //create course from an institution
    @PostMapping("/{idInstitution}/courses")
    @ApiOperation("Agregar curso a institución")
    public ResponseEntity<Set<InstitutionEntity>>
    addInstitutionCourse(@PathVariable Long idInstitution, @RequestBody CourseDTO dto)
    {
        CourseDTO courseSaved = courseService.save(dto);
        institutionService.addCourse(idInstitution, courseSaved.getId());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    //Add institution-course relationship
    @PostMapping("/{idInstitution}/courses/{idCourse}")
    @ApiOperation("Agregar curso")
    public ResponseEntity<Set<InstitutionEntity>>
    addCourse(@PathVariable Long idInstitution, @PathVariable Long idCourse)
    {
        institutionService.addCourse(idInstitution, idCourse);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    //remove institution-course relationship
    @DeleteMapping("/{idInstitution}/courses/{idCourse}")
    @ApiOperation("Remover curso de institución")
    public ResponseEntity<InstitutionEntity>
    removeCourse(@PathVariable Long idInstitution, @PathVariable Long idCourse)
    {
        institutionService.removeCourse(idInstitution, idCourse);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
