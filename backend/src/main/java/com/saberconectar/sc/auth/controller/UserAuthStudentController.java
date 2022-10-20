package com.saberconectar.sc.auth.controller;

import com.saberconectar.sc.auth.dto.AuthenticationRequest;
import com.saberconectar.sc.auth.dto.AuthenticationResponse;
import com.saberconectar.sc.auth.service.JwtUtils;
import com.saberconectar.sc.auth.service.UserDetailsCustomService;
import com.saberconectar.sc.dto.InstitutionDTO;
import com.saberconectar.sc.dto.StudentDTO;
import com.saberconectar.sc.service.InstitutionService;
import com.saberconectar.sc.service.StudentService;
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
public class UserAuthStudentController {
    private UserDetailsCustomService userDetailsService;
    private AuthenticationManager authenticationManager;
    private StudentService studentService;
    private JwtUtils jwtTokenUtil;
    private InstitutionService institutionService;
    @Autowired
    public UserAuthStudentController(
            UserDetailsCustomService userDetailsService,
            AuthenticationManager authenticationManager,
            JwtUtils jwtTokenUtil,
            StudentService studentService,
            InstitutionService institutionService){
        this.userDetailsService = userDetailsService;
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.studentService = studentService;
        this.institutionService = institutionService;
    }
    @PostMapping("/institution/register")
    public ResponseEntity<InstitutionDTO> signUp(@Valid @RequestBody InstitutionDTO user) throws Exception{
        InstitutionDTO institutionSaved = institutionService.institutionRegister(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(institutionSaved);
    }
    @PostMapping("/student/register")
    public ResponseEntity<StudentDTO> signUp(@Valid @RequestBody StudentDTO user) throws Exception{
        StudentDTO studentRegistered = studentService.studentRegister(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(studentRegistered);
    }
    @PostMapping("/login")
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
