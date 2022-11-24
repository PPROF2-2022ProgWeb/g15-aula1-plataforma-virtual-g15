package com.saberconectar.sc.dto;

import com.saberconectar.sc.entity.CourseEntity;
import com.saberconectar.sc.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;
import javax.validation.Valid;
import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class InstitutionDTO {
    private Long id;

    @Size(min = 3, max = 50, message = "{student.name.size}")
    @NotNull(message = "{student.name.null}")
    private String name;

    @Length(min = 11, message = "{institution.cuitNumber.length}")
    @NotNull(message = "{institution.cuitNumber.null}")
    private String cuitNumber;

    @AssertFalse(message = "{user.deleted.boolean}")
    private Boolean deleted;

    @Valid
    private UserEntity userEntity;
    private Set<CourseEntity> courses;
}
