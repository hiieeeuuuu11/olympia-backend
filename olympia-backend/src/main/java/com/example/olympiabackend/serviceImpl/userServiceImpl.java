package com.example.olympiabackend.serviceImpl;

import com.example.olympiabackend.model.User;
import com.example.olympiabackend.repository.user_infoRepository;
import com.example.olympiabackend.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userServiceImpl implements userService {
    @Autowired
    user_infoRepository userRe;

    @Override
    public User signup(User user) {
        return userRe.save(user);
    }

    @Override
    public User login(User user) {
        return userRe.findByUsernameAndPassword(user.getUsername(),user.getPassword());
    }


}
