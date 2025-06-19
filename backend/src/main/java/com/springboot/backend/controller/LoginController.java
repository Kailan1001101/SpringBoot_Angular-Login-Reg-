package com.springboot.backend.controller;


import com.springboot.backend.entity.Login;
import com.springboot.backend.service.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;


    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping
    public Optional<Login> getListLogin(@RequestParam String username){
        return loginService.getAllLogins(username);
    }

    @GetMapping("/all")
    public List<Login> getList(){
        return loginService.getAll();
    }

    @PostMapping
    public void insertLogin(@RequestBody Login logins){
        loginService.insertLogins(logins);

    }

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(@RequestBody Login loginRequest) {
        Optional<Login> userOpt = loginService.getAllLogins(loginRequest.getUsername());
        if (userOpt.isPresent()) {
            Login user = userOpt.get();

            // For plain text passwords (not recommended)
            if (user.getPassword().equals(loginRequest.getPassword())) {
                return ResponseEntity.ok("Login successful");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid password");
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not found");
        }
    }

}
