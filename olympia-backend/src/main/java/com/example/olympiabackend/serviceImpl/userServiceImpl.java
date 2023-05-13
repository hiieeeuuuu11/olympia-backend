package com.example.olympiabackend.serviceImpl;

import com.example.olympiabackend.model.user_info;
import com.example.olympiabackend.repository.user_infoRepository;
import com.example.olympiabackend.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userServiceImpl implements userService {
    @Autowired
    user_infoRepository userRe;

    @Override
    public user_info signup(user_info user) {
        return userRe.save(user);
    }

    @Override
    public user_info login(user_info user) {
        return userRe.findByUsernameAndPassword(user.getUsername(),user.getPassword());
    }


}
