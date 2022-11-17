package com.saberconectar.sc.dto;

import lombok.Getter;
import lombok.Setter;

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
    private Boolean isAdmin;
    /*
    private Long countryId;
    private Long provinceId;
    private Long cityId;

     */
}
