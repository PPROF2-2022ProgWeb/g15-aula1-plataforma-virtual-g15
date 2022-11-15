package com.saberconectar.sc.dto;

import com.saberconectar.sc.entity.InstitutionEntity;
import com.saberconectar.sc.entity.StudentEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
public class CourseListDTO {
    private Long id;
    private String name;
    private String description;
    private LocalDate beginningDay;
    private LocalDate endingDay;
    private Boolean deleted=Boolean.FALSE;
    private List<InstitutionDTO> institutions;
    private List<StudentDTO> students;
}
