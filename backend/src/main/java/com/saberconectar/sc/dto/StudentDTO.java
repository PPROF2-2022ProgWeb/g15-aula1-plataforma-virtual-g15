package com.saberconectar.sc.dto;

import com.saberconectar.sc.entity.CourseEntity;
import com.saberconectar.sc.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;
@Getter
@Setter
public class StudentDTO {
    private Long id;
    @Size(min = 3, max = 50, message = "{student.name.size}")
    @NotNull(message = "{student.name.null}")
    private String name;
    @Size(min = 3, max = 50, message = "{student.lastname.size}")
    @NotNull(message = "{student.lastname.null}")
    private String lastname;
    @Length(min = 7, message = "{student.documentNumber.length}")
    @NotNull(message = "{student.documentNumber.null}")
    private String documentNumber;
    @NotNull(message = "{student.date.null}")
    private LocalDate date;
    @AssertFalse(message = "{user.deleted.boolean}")
    private Boolean deleted;
    @Valid
    private UserEntity userEntity;
    private Set<CourseEntity> courses;
}
