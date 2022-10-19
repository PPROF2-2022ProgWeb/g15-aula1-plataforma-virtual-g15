package com.saberconectar.sc.auth.service;

import com.saberconectar.sc.auth.repository.UserRegRepository;
import com.saberconectar.sc.entity.InstitutionEntity;
import com.saberconectar.sc.entity.StudentEntity;

@Service
public class UserDetailsCustomService implements UserDetailsService{
    @Autowired
    private UserRegRepository userRegRepository;
    @Override
    public UserDetails loadInstitutionByUsername(String userName) throws UsernameNotFoundException {
        Object<InstitutionEntity, StudentEntity> userEntity = userRegRepository.findByUsername(userName);
        if (userEntity == null){
            throw new UsernameNotFoundException(("Username or password not found"));
        }
        return new User(userEntity.getUsername(), userEntity.getPassword(), Collections.emptyList());
    }
}
