package com.example.caseTeaNetw.jpa;

import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.caseTeaNetw.EndUsers;

import java.util.List;

public interface EndUserRepository extends JpaRepository<EndUsers,Integer> {
    List<EndUsers> findByName(String name);

    List<EndUsers> findByUsername(String username);

    //List<EndUsers> findByUsernameAndPassword(String username, String password);

    default EndUsers updateUser(int userId, EndUsers updatedUser) {
        return findById(userId)
                .map(existingUser -> {
                    BeanUtils.copyProperties(updatedUser, existingUser, "id");
                    return save(existingUser);
                })
                .orElse(null);
    }

}
