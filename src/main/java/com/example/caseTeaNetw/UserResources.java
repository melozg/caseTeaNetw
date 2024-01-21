package com.example.caseTeaNetw;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResources {
    private UsersDaoService service;

    public UserResources(UsersDaoService service) {
        this.service = service;
    }

    //GET /users
    @GetMapping("/user")
    public List<EndUsers> retrieveAllUsers() {
        return service.findAll();
    }

    //GET user information by user id
    @GetMapping("/user/{id}")
    public EndUsers retrieveUser(@PathVariable int id) {
        EndUsers user =  service.findOne(id);
            if(user==null)
                throw new UserNotFoundException("User with Id: " + id + " is not found");
            return user;
    }

    //User create endpoint
    @PostMapping("/user")
    public ResponseEntity<EndUsers> createUser(@RequestBody EndUsers user) {

        EndUsers savedUser =  service.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();

    }


}
