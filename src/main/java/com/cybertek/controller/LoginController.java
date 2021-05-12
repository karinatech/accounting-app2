package com.cybertek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {


@GetMapping("/login")
    public String doLogin(){
//    return "user/create";
    return "html/page-login";
}
@GetMapping("/layout-horizontal")
    public String changeLayout(){
    return "html/layout-horizontal-dark";
}
@GetMapping("/data-table")
    public String getDataTable(){
    return "html/table-datatable";
}



}
