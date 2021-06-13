package com.cybertek.service;

import com.cybertek.dto.RoleDTO;
import com.cybertek.dto.UserDTO;
import com.cybertek.entity.User;

import java.util.List;

public interface UserService {
    UserDTO findByUserName(String userName);
    List<User>listAllUsers();
    List<UserDTO>listAllUsersByRole(String role);
    UserDTO save(UserDTO userDTO);
    void delete(String userName);
    void update(UserDTO userDTO);
    RoleDTO findRoleByUserName(String userName);


}
