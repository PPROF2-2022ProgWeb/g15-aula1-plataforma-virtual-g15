package com.saberconectar.sc.dto;

import com.saberconectar.sc.entity.InstitutionEntity;
import com.saberconectar.sc.entity.StudentEntity;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class UserDTO {
    private Long id;
    private String email;
    private String password;
    private Boolean deleted;
    private Long countryId;
    private Long provinceId;
    private Long cityId;
    private StudentEntity studentEntity;
    private InstitutionEntity institutionEntity;
}
