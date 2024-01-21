package com.example.caseTeaNetw;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

@Component
public class UsersDaoService {
    private static List<EndUsers> users = new ArrayList<>();


    static {
        users.add(new EndUsers(1, "melo", "melike", "1234", "admin"));
        users.add(new EndUsers(2, "mertkal", "mert", "12345", "enduser"));
        users.add(new EndUsers(3, "meleğim", "melek", "123456", "enduser"));
    }

    private static int usersCount = 3;

    public List<EndUsers> findAll() {
        return users;
    }

    public EndUsers save(EndUsers user) {

        user.setId(++usersCount);
        users.add(user);
        return user;
    }


    public EndUsers findOne(int id) {
        Predicate<? super EndUsers> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }
}
