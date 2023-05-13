package com.example.olympiabackend.repository;

import com.example.olympiabackend.model.profile_user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface profile_userRepository extends JpaRepository<profile_user,Integer> {

}
