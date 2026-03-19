package com.mhuapi.auth.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {



    @GetMapping("/login")
    public String  sayHello(){
        return "LOGIN SUCCESSFULLY!";
    }
    @GetMapping("/upd")
    public String  upddate(){
        return "LOGIN SUCCESSFULLY!";
    }
}
