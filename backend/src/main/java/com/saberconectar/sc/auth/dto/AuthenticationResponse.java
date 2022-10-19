package com.saberconectar.sc.auth.dto;
@Getter
@Setter
@AllArgsConstructor
public class AuthenticationResponse {
    private String username;
    private String jwt;
}
