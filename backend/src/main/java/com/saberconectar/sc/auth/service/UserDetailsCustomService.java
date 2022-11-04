package com.saberconectar.sc.auth.service;

import com.saberconectar.sc.auth.repository.UserRegRepository;
import com.saberconectar.sc.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsCustomService implements UserDetailsService{
    @Autowired
    private UserRegRepository userRegRepository;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserEntity userEntity = userRegRepository.findByEmail(userName);
        if (userEntity == null){
            throw new UsernameNotFoundException(("Username or password not found"));
        }
        return new User(userEntity.getEmail(), userEntity.getPassword(), Collections.emptyList());
    }
}
