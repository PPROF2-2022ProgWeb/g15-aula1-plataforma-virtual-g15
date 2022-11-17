package com.saberconectar.sc.auth.controller;

import com.saberconectar.sc.auth.dto.AuthenticationRequest;
import com.saberconectar.sc.auth.dto.AuthenticationResponse;
import com.saberconectar.sc.auth.service.JwtUtils;
import com.saberconectar.sc.auth.service.UserDetailsCustomService;
import com.saberconectar.sc.dto.InstitutionDTO;
import com.saberconectar.sc.dto.StudentDTO;
import com.saberconectar.sc.dto.UserDTO;
import com.saberconectar.sc.exception.ParamNotFound;
import com.saberconectar.sc.repository.UserRepository;
import com.saberconectar.sc.service.InstitutionService;
import com.saberconectar.sc.service.StudentService;
import com.saberconectar.sc.service.UserService;
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
    private UserService userService;
    private UserRepository userRepository;
    @Autowired
    public UserAuthStudentController(
            UserDetailsCustomService userDetailsService,
            AuthenticationManager authenticationManager,
            JwtUtils jwtTokenUtil,
            StudentService studentService,
            InstitutionService institutionService,
            UserService userService,
            UserRepository userRepository){
        this.userDetailsService = userDetailsService;
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.studentService = studentService;
        this.institutionService = institutionService;
        this.userService = userService;
        this.userRepository = userRepository;
    }
    @PostMapping("/institution/register")
    public ResponseEntity<InstitutionDTO> signUp(@Valid @RequestBody InstitutionDTO user) throws Exception{
        if(!existsByEmail(user.getUserEntity().getEmail())) {
            InstitutionDTO institutionSaved = institutionService.institutionRegister(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(institutionSaved);
        }else{
            throw new ParamNotFound("Email existente");
        }
    }
    @PostMapping("/student/register")
    public ResponseEntity<StudentDTO> signUp(@Valid @RequestBody StudentDTO user) throws Exception{
        if(!existsByEmail(user.getUserEntity().getEmail())){
            StudentDTO studentRegistered = studentService.studentRegister(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(studentRegistered);
        }else{
            throw new ParamNotFound("Email existente");
        }
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
        UserDTO dto = userService.getUserByEmail(username, false, false);
        final String jwt = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(username,jwt,dto.getIsStudent(),dto.getId(),dto.getIsAdmin()));
        //TODO usar metodo getReferenceByEmail en entidad Estudiante y Institucion, de acuerdo a en cual de las dos , este email exista, realiza el resto de las funciones de devolucion.
    }
    @GetMapping("/email/{email}")
    public boolean existsByEmail(@PathVariable String email){
        if(userRepository.existsByEmail(email)){
            return true;
        }
        return false;
    }
}
