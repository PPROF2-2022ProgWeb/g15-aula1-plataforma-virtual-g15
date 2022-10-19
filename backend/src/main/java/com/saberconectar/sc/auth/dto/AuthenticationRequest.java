package com.saberconectar.sc.auth.dto;

import lombok.*;

@Getter
@Setter
public class AuthenticationRequest {
    private String username;
    private String password;
}
