package com.saberconectar.sc.controller;

import com.saberconectar.sc.dto.UserDTO;
import com.saberconectar.sc.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/users")
@Api(tags="Usuarios")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/{id}")
    @ApiOperation("Mostrar usuario por id")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id){
        UserDTO user = userService.getUserById(id, false, false);
        return ResponseEntity.ok().body(user);
    }
    @GetMapping("/email/{email}")
    @ApiOperation("Mostrar usuario por nombre")
    public ResponseEntity<UserDTO> getUserByUsername(@PathVariable String email){
        UserDTO user = userService.getUserByEmail(email, false, false);
        return ResponseEntity.ok().body(user);
    }
    @PostMapping
    @ApiOperation("Guardar usuario")
    public ResponseEntity<UserDTO> save(@RequestBody UserDTO user){
        UserDTO userSaved = userService.save(user, false, false);
        return ResponseEntity.status(HttpStatus.CREATED).body(userSaved);
    }
    @PutMapping("/{id}")
    @ApiOperation("Actualizar usuario")
    public ResponseEntity<UserDTO> update(@PathVariable Long id, @RequestBody UserDTO user) {
        UserDTO userUpdated = this.userService.update(id, user, false, false);
        return ResponseEntity.ok().body(userUpdated);
    }
    @DeleteMapping("/{id}")
    @ApiOperation("Borrar usuario")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        this.userService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
