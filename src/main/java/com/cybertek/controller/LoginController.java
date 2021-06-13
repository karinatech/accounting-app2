package com.cybertek.controller;


import com.cybertek.annotation.DefaultExceptionMessage;
import com.cybertek.cnverters.MapperUtil;
import com.cybertek.dto.UserDTO;
import com.cybertek.entity.AuthenticationRequest;
import com.cybertek.entity.ResponseWrapper;
import com.cybertek.entity.Role;
import com.cybertek.entity.User;

import com.cybertek.exception.TicketingProjectException;
import com.cybertek.implementations.SecurityServiceImplementation;
import com.cybertek.service.RoleService;
import com.cybertek.service.SecurityService;
import com.cybertek.service.UserService;
import com.cybertek.util.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class LoginController {

private AuthenticationManager authenticationManager;

    private UserService userService;
    private MapperUtil mapperUtil;
    private JwtUtil jwtUtil;
    private SecurityServiceImplementation securityServiceImplementation;
    private RoleService roleService;

    public LoginController(AuthenticationManager authenticationManager, UserService userService, MapperUtil mapperUtil, JwtUtil jwtUtil, SecurityServiceImplementation securityServiceImplementation, RoleService roleService) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.mapperUtil = mapperUtil;
        this.jwtUtil = jwtUtil;
        this.securityServiceImplementation = securityServiceImplementation;
        this.roleService = roleService;
    }

    @RequestMapping("/hello")
    public ResponseEntity<ResponseWrapper> read(){
        List<User> result = userService.listAllUsers();
        return ResponseEntity.ok(new ResponseWrapper("Successfully retrieved users",result));
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?>createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        String password = authenticationRequest.getPassword();
        String username = authenticationRequest.getUsername();

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username,password);
        authenticationManager.authenticate(authentication);


        final UserDetails userDetails = securityServiceImplementation
                .loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new ResponseWrapper("Login Successful",jwt));

   }
    @GetMapping("/users")
    @DefaultExceptionMessage(defaultMessage = "Something went wrong, try again!")
    @PreAuthorize("hasAuthority('Admin')")
    public ResponseEntity<ResponseWrapper> readAll(){
        List<User> result = userService.listAllUsers();
        return ResponseEntity.ok(new ResponseWrapper("Successfully retrieved users",result));
    }
//    @PostMapping("/create-user")
//    @DefaultExceptionMessage(defaultMessage = "Something went wrong, try again!")
//    @PreAuthorize("hasAuthority('Admin')")
//    public ResponseEntity<ResponseWrapper> doRegister(@RequestBody UserDTO userDTO) throws TicketingProjectException {
//        UserDTO createdUser = userService.save(userDTO);
//        return ResponseEntity.ok(new ResponseWrapper("User has been created!",createdUser));
//    }



}
