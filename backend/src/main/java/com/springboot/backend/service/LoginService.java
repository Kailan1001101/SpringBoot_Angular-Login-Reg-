package com.springboot.backend.service;

import com.springboot.backend.entity.Login;
import com.springboot.backend.repository.LoginRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginService {

    private final LoginRepository loginRepo;

    public LoginService(LoginRepository loginRepo) {
        this.loginRepo = loginRepo;
    }

    public Optional<Login> getAllLogins(String username){
        return loginRepo.findByUsername(username);
    }

    public List<Login> getAll(){
        return loginRepo.findAll();
    }

    public void insertLogins(Login logins){
        loginRepo.save(logins);
    }
}
