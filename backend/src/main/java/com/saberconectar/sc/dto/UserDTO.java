package com.saberconectar.sc.dto;

import com.saberconectar.sc.entity.InstitutionEntity;
import com.saberconectar.sc.entity.StudentEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UserDTO {
    private Long id;
    private String email;
    private String password;
    private Boolean deleted;
    private String countryId;
    private String provinceId;
    private String cityId;
    private Boolean isStudent;
    private Long studentId;
    private Long institutionId;
    /*
    private Long countryId;
    private Long provinceId;
    private Long cityId;

     */
}
