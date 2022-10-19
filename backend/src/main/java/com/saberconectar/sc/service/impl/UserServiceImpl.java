package com.saberconectar.sc.service.impl;

import com.saberconectar.sc.dto.UserDTO;
import com.saberconectar.sc.entity.UserEntity;
import com.saberconectar.sc.exception.ParamNotFound;
import com.saberconectar.sc.mapper.UserMapper;
import com.saberconectar.sc.repository.UserRepository;
import com.saberconectar.sc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRepository userRepository;
    public UserDTO save(UserDTO dto, Boolean setStudent, Boolean setInstitution) {
        UserEntity entity = userMapper.userDTO2Entity(dto);
        UserEntity entitySaved = userRepository.save(entity);
        UserDTO result = userMapper.userEntity2DTO(entitySaved, setStudent, setInstitution);
        return result;
    }
    public UserDTO getUserById(Long id, Boolean setStudent, Boolean setInstitution) {
        isCorrect(id);
        UserEntity entity = userRepository.getReferenceById(id);
        UserDTO result = userMapper.userEntity2DTO(entity, setStudent, setInstitution);
        return result;
    }
    public UserDTO update(Long id, UserDTO user, Boolean setStudent, Boolean setInstitution) {
        isCorrect(id);
        UserEntity entityId = userRepository.getReferenceById(id);
        UserEntity entity = userMapper.update(entityId,user);
        UserEntity entityUpdated = userRepository.save(entity);
        UserDTO result = userMapper.userEntity2DTO(entityUpdated, setStudent, setInstitution);
        return result;
    }
    public void delete(Long id) {
        isCorrect(id);
        this.userRepository.deleteById(id);
    }
    public void isCorrect(Long id){
        if(!userRepository.existsById(id)){
            throw new ParamNotFound("Invalid id");
        }
    }
}
