package com.saberconectar.sc.auth.dto;

import lombok.*;
@Getter
@Setter
@AllArgsConstructor
public class AuthenticationResponse {
    private String username;
    private String jwt;
    private Boolean isStudent;
    private Long id;
}
