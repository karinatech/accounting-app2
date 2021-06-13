package com.cybertek.implementations;

import com.cybertek.cnverters.MapperUtil;
import com.cybertek.dto.UserDTO;
import com.cybertek.entity.User;
import com.cybertek.service.RoleService;
import com.cybertek.service.SecurityService;
import com.cybertek.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class SecurityServiceImplementation implements SecurityService {
    private UserService userService;
    private MapperUtil mapperUtil;
    private RoleService roleService;

    public SecurityServiceImplementation(UserService userService, MapperUtil mapperUtil) {
        this.userService = userService;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        UserDTO foundUser= userService.findByUserName(s);
//        System.out.println("here is user "+ foundUser);
//        if(foundUser==null){
//            throw new UsernameNotFoundException("This user does not exists");
//        }
//        return new org.springframework.security.core.userdetails.User(foundUser.getId().toString(),foundUser.getPassword(),listAuthorities(foundUser));
//    }
        return new org.springframework.security.core.userdetails.User("kari","$2y$12$PmCy9jKnBLcxPJ2DVlqShuAT38r0NybMGCjb85dxF2VY.tuwkD7a2",new ArrayList<>());

    }
    public Collection<? extends GrantedAuthority> listAuthorities(UserDTO user) {

        List<GrantedAuthority> authorityList = new ArrayList<>();

        GrantedAuthority authority = new SimpleGrantedAuthority(roleService.findById(user.getId()));
        authorityList.add(authority);
        System.out.println("Here is list f authorities "+ authorityList.size());
        return authorityList;
    }
    @Override
    public User loadUser(String param) {
        UserDTO user =  userService.findByUserName(param);
        return mapperUtil.convert(user,new User());
    }
}
