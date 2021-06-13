package com.cybertek.implementations;

import com.cybertek.cnverters.MapperUtil;
import com.cybertek.dto.RoleDTO;
import com.cybertek.dto.UserDTO;
import com.cybertek.entity.User;
import com.cybertek.repo.UserRepo;
import com.cybertek.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements UserService {

    private MapperUtil mapperUtil;
    private UserRepo userRepo;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(PasswordEncoder passwordEncoder, MapperUtil mapperUtil, UserRepo userRepo) {
      this.passwordEncoder=passwordEncoder;
        this.mapperUtil = mapperUtil;
        this.userRepo = userRepo;
    }

    @Override
    //email=username
    public UserDTO findByUserName(String userName) {
    User user = userRepo.findByEmail(userName);
    UserDTO userDTO=mapperUtil.convert(user,new UserDTO());
        System.out.println("here is user from DB "+ userDTO.getEmail() + " "+userDTO.getPassword());
        return userDTO;
    }

    @Override
    public List<User> listAllUsers() {
        List<User>listUsers=userRepo.findAll();
        System.out.println(listUsers.get(0).getEmail()+"here is user from dB");
        return listUsers;
    }

    @Override
    public List<UserDTO> listAllUsersByRole(String role) {
        List<User>users=userRepo.findAllByRolesNameIgnoreCase(role);
        return users.stream().map(obj->{return mapperUtil.convert(obj,new UserDTO());})
                .collect(Collectors.toList());
    }


    @Override
    public UserDTO save(UserDTO userDTO) {
User user=mapperUtil.convert(userDTO,new User());
user.setPassword(passwordEncoder.encode(user.getPassword()));
userRepo.save(user);
return mapperUtil.convert(userRepo.findByEmail(userDTO.getEmail()),new UserDTO());
    }

    @Override
    public void delete(String userName) {
        User user = userRepo.findByEmail(userName);
        user.setEmail(user.getEmail()+"-"+user.getId());
        user.setDeleted(true);
    }

    @Override
    public void update(UserDTO userDTO) {
        User user=userRepo.findByEmail(userDTO.getEmail());
        User convertedUser=mapperUtil.convert(userDTO,new User());
        convertedUser.setPassword(passwordEncoder.encode(convertedUser.getPassword()));
        convertedUser.setId(user.getId());
        userRepo.save(convertedUser);
    }

    @Override
    public RoleDTO findRoleByUserName(String userName) {
        return null;
    }
}
