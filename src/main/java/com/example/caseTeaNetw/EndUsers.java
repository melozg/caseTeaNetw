package com.example.caseTeaNetw;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.hibernate.id.uuid.UuidGenerator;



@Entity(name = "user_details")
public class EndUsers {

    protected EndUsers() {

    }

    //private UuidGenerator uuid;
    @Id
    @GeneratedValue
    private Integer id;
    private String username;
    private String name;
    private String password;
    private String role;

    //Constructor
    public EndUsers( Integer id, String username, String name, String password, String role) {

        //super(); video25.step07
        //this.uuid = uuid;
        this.id = id;
        this.username = username;
        this.name = name;
        this.password = password;
        this.role = role;
    }


    //Getters and Setters

    //public UuidGenerator getUuid() {
    //    return uuid;
    //}

    //public void setUuid(UuidGenerator uuid) {
    //    this.uuid = uuid;
    //}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
