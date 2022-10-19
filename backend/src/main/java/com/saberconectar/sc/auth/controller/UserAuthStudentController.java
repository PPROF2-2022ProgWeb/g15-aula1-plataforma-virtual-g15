package com.saberconectar.sc.auth.controller;

import com.saberconectar.sc.auth.dto.AuthenticationResponse;
import com.saberconectar.sc.auth.service.JwtUtils;
import com.saberconectar.sc.auth.service.UserDetailsCustomService;
import com.saberconectar.sc.dto.StudentDTO;
import com.saberconectar.sc.service.StudentService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/auth/student")
public class UserAuthStudentController {
    private UserDetailsCustomService userDetailsService;
    private AuthenticationManager authenticationManager;
    private StudentService studentService;
    private JwtUtils jwtTokenUtil;
    @Autowired
    public UserAuthStudentController(
            UserDetailsCustomService userDetailsService,
            AuthenticationManager authenticationManager,
            JwtUtils jwtTokenUtil,
            StudentService studentService){
        this.userDetailsService = userDetailsService;
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.studentService = studentService;
    }
    @PostMapping("/register")
    public ResponseEntity<Boolean> signUp(@Valid @RequestBody StudentDTO user) throws Exception{
        this.studentService.studentRegister(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
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