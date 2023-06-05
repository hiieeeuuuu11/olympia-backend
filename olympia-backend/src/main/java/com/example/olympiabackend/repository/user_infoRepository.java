package com.example.olympiabackend.repository;

import com.example.olympiabackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface user_infoRepository extends JpaRepository<User,Integer> {
    User findByUsername(String username);

    User findByUsernameAndPassword(String username, String password);
}
