package com.example.olympiabackend.controller;

import com.example.olympiabackend.model.user_info;
import com.example.olympiabackend.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class userController {

    @Autowired
    userService userSe;

    @CrossOrigin
    @PostMapping("/signup")
    public user_info signIn(@RequestBody user_info user){
        return userSe.signup(user);
        //return HttpStatus.OK;
    }

    @GetMapping("/login")
    @CrossOrigin
    public user_info login(@RequestBody user_info user){
        return userSe.login(user);
    }

}
