package com.example.olympiabackend.service;

import com.example.olympiabackend.model.user_info;

public interface userService {

    public user_info signup(user_info user);
    public user_info login(user_info user);


}
