package com.cybertek.service;

import com.cybertek.dto.UserDTO;
import com.cybertek.entity.User;

import java.util.List;

public interface UserService {
    UserDTO findByUserName(String userName);
    List<UserDTO>listAllUsers();
    List<UserDTO>listAllUsersByRole(String role);
    void save(UserDTO userDTO);
    void delete(String userName);
    void update(UserDTO userDTO);


}
