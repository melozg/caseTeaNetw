package com.example.caseTeaNetw;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class UsersDaoService {
    private static List<EndUsers> users = new ArrayList<>();

    static{
        users.add(new EndUsers( 1 , "melo", "melike", "1234","admin" ));
        users.add(new EndUsers( 2 , "mertkal", "mert", "12345","enduser" ));
        users.add(new EndUsers( 3 , "meleğim", "melek", "123456","enduser" ));
    }

    public List<EndUsers> findAll(){
        return users;
    }
/*
    public User findOne(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().get();
    }*/
}
