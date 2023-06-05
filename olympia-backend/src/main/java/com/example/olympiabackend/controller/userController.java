package com.example.olympiabackend.controller;

import com.example.olympiabackend.config.JwtService;
import com.example.olympiabackend.model.JWT.JwtResponse;
import com.example.olympiabackend.model.Role;
import com.example.olympiabackend.model.User;
import com.example.olympiabackend.repository.user_infoRepository;
import com.example.olympiabackend.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.net.URLEncoder;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class userController {

    @Autowired
    userService userSe;

    @Autowired
    user_infoRepository repository;

    @Autowired
    JwtService jwtservice;

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @CrossOrigin
    @PostMapping("/signup")
    public User signIn(@RequestBody User user){
        var userr = User.builder()
                .username(user.getUsername())
                .password(passwordEncoder.encode(user.getPassword()))
                .role(Role.ADMIN)
                .build();
        return userSe.signup(userr);
    }

    @CrossOrigin
    @PostMapping("/login")
    public JwtResponse login(@RequestBody User user){
        System.out.println(user);
        System.out.println(authenticationManager);
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            user.getUsername(),
                            user.getPassword()
                    )
            );
        } catch (AuthenticationException e) {
            return new JwtResponse("Fail to authenticate");
        }
        User userjwt = userSe.login(user);
        String jwt = jwtservice.generateToken(user);
        System.out.println(jwt);
        return new JwtResponse(jwt);
    }

    @GetMapping("/getUsername")
    public String login(@RequestHeader("Authorization") String authHeader ){
        String token =authHeader.substring("Bearer ".length());
        return jwtservice.extractUsername(token);
    }

}
