package com.example.caseTeaNetw;

import com.example.caseTeaNetw.jpa.EndUserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserJpaResource {

    private UsersDaoService service;

    private EndUserRepository repository;

    public UserJpaResource(UsersDaoService service, EndUserRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    //GET /users
    @GetMapping("/jpa/user")
    public List<EndUsers> retrieveAllUsers() {
        return repository.findAll();
    }

    //GET user information by user id
    @GetMapping("/jpa/user/{id}")
    public EndUsers retrieveUser(@PathVariable int id) {
        Optional<EndUsers> user =  repository.findById(id);
        if(user.isEmpty())
            throw new UserNotFoundException("User with Id: " + id + " is not found");
        return user.get();
    }

    @GetMapping("/jpa/user/byName/{name}")
    public List<EndUsers> retrieveUserByName(@PathVariable String name) {
        List<EndUsers> user =  repository.findByName(name);
        if(user.isEmpty())
            throw new UserNotFoundException("User with Name: " + name + " is not found");
        return user;

    }

    // change it so only admin can delete user
    // add error message
    @DeleteMapping("/jpa/user/{id}")
    public void deleteUser(@PathVariable int id) {
        repository.deleteById(id);
    }

    //User create endpoint
    // change it so only admin can add user
    @PostMapping("/jpa/user")
    public ResponseEntity<EndUsers> createUser(@RequestBody EndUsers user) {

        EndUsers savedUser =  repository.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();

    }

    @PostMapping("/jpa/user/login")
    public ResponseEntity<EndUsers> loginUser(@RequestParam String username){

        List<EndUsers> findUser = repository.findByUsername(username);

        if(findUser.isEmpty())
            throw new UserNotFoundException("User with username: " + username + " is not found");
        return (ResponseEntity<EndUsers>) findUser;
    }

    @PutMapping("/jpa/user/update_user")
    public EndUsers UpdateUser(@PathVariable int id, @RequestBody EndUsers users) {
        Optional<EndUsers> user = repository.findById(id);
        EndUsers updatedUser = repository.updateUser(id, users);

        if(user.isEmpty())
            throw new UserNotFoundException("User with id: " + id + " is not found");
        return updatedUser;

    }

    //@PutMapping("/jpa/user/name")

    //@PutMapping("/jpa/user/password")



}
