package com.example.olympiabackend.repository;

import com.example.olympiabackend.model.user_info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface user_infoRepository extends JpaRepository<user_info,Integer> {
    user_info findByUsernameAndPassword(String username,String password);
}
