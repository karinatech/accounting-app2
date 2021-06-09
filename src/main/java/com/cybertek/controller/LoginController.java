package com.cybertek.controller;


import com.cybertek.entity.AuthenticationRequest;
import com.cybertek.entity.ResponseWrapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {


    @PostMapping("/authenticate")
    public ResponseEntity<ResponseWrapper> doLogin(@RequestBody AuthenticationRequest authenticationRequest) {

        String password = authenticationRequest.getPassword();
        String username = authenticationRequest.getUsername();

        return ResponseEntity.ok(new ResponseWrapper("Login Successful", ));

    }

@GetMapping("/layout-horizontal")
    public String changeLayout(){
    return "html/layout-horizontal-dark";
}

@GetMapping("/data-table")
    public String getDataTable(){
    return "html/table-datatable";
}

    @GetMapping("/basic-form")
    public String getForm(){ return "html/form-basic"; }



}
