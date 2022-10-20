package com.saberconectar.sc.auth.controller;

import com.saberconectar.sc.auth.dto.AuthenticationRequest;
import com.saberconectar.sc.auth.dto.AuthenticationResponse;
import com.saberconectar.sc.auth.service.JwtUtils;
import com.saberconectar.sc.auth.service.UserDetailsCustomService;
import com.saberconectar.sc.dto.InstitutionDTO;
import com.saberconectar.sc.service.InstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/auth")
public class UserAuthInstitutionController {
    private UserDetailsCustomService userDetailsService;
    private AuthenticationManager authenticationManager;
    private InstitutionService institutionService;
    private JwtUtils jwtTokenUtil;
    @Autowired
    public UserAuthInstitutionController(
            UserDetailsCustomService userDetailsService,
            AuthenticationManager authenticationManager,
            JwtUtils jwtTokenUtil,
            InstitutionService institutionService){
        this.userDetailsService = userDetailsService;
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.institutionService = institutionService;
    }
    @PostMapping("/institution/register")
    public ResponseEntity<InstitutionDTO> signUp(@Valid @RequestBody InstitutionDTO user) throws Exception{
        InstitutionDTO institutionSaved = institutionService.institutionRegister(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(institutionSaved);
    }
    @PostMapping("/institution/login")
    public ResponseEntity<AuthenticationResponse> singIn(@RequestBody AuthenticationRequest authRequest) throws Exception{
        UserDetails userDetails;
        try{
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
            userDetails = (UserDetails) auth.getPrincipal();
        } catch (BadCredentialsException e){
            throw new Exception("Incorrect username or password", e);
        }
        final String username = authRequest.getUsername();
        final String jwt = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(username,jwt));
    }
}
