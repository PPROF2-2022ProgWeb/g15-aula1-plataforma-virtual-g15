package com.saberconectar.sc.service;

import com.saberconectar.sc.dto.UserDTO;
public interface UserService {
    UserDTO save(UserDTO dto, Boolean setStudent, Boolean setInstitution);
    UserDTO getUserById(Long id, Boolean setStudent, Boolean setInstitution);
    UserDTO update(Long id, UserDTO user, Boolean setStudent, Boolean setInstitution);
    void delete (Long id);
    void isCorrect(Long id);
}
