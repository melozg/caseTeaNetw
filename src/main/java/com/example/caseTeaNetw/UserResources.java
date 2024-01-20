package com.example.caseTeaNetw;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class UserResources {
    private UsersDaoService service;
    public UserResources(UsersDaoService service){
        this.service = service;
    }

    //GET /users
    @GetMapping("/users")
    public List<EndUsers> retrieveAllUsers(){
        return service.findAll();
    }
}
