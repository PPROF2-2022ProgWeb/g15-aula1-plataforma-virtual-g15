package com.saberconectar.sc.dto;

import com.saberconectar.sc.entity.InstitutionEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
public class CourseDTO {
    private Long id;
    private String name;
    private String description;
    private LocalDate beginningDay;
    private LocalDate endingDay;
    private Boolean deleted;
    private List<InstitutionEntity> institutions;
}
