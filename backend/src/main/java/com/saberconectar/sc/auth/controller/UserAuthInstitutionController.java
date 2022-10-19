package com.saberconectar.sc.auth.controller;

import com.saberconectar.sc.auth.service.JwtUtils;
import com.saberconectar.sc.auth.service.UserDetailsCustomService;
import com.saberconectar.sc.dto.InstitutionDTO;
import com.saberconectar.sc.service.InstitutionService;
import com.saberconectar.sc.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/auth/institution")
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
    @PostMapping("/register")
    public ResponseEntity<Boolean> signUp(@Valid @RequestBody InstitutionDTO user) throws Exception{
        this.institutionService.institutionRegister(user);
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
