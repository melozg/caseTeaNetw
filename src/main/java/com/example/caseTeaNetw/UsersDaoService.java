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
        users.add(new EndUsers(1, "melozg", "melike", "1234", "admin"));
    }

    private static int usersCount = 1;

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

    public EndUsers findbyName(String name) {
        Predicate<? super EndUsers> predicate = user -> user.getName().equals(name);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public void deleteById(int id) {
        Predicate<? super EndUsers> predicate = user -> user.getId().equals(id);
        users.removeIf(predicate);
    }
}
