package com.example.olympiabackend.controller.competition;

import com.example.olympiabackend.config.JwtService;
import com.example.olympiabackend.model.User;
import com.example.olympiabackend.model.questions.round3;
import com.example.olympiabackend.service.questionService.round3.round3Service;
import com.example.olympiabackend.serviceImpl.questionServiceImpl.round3.round3ServiceImpl;
import com.example.olympiabackend.storage.sample.nextquestionr3;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class round3socket {

    @Autowired
    round3Service r3service;

    public static int i4=0;
    public Map<String,String> allanswer = new HashMap<>();
    public List<Map<String, Object>> allround3 ;

    @Autowired
    private JwtService jwt;


    @PostConstruct
    public void init() {
        allround3 = r3service.getAllwithImage();
    }


    @MessageMapping("/pushr3_1")
    @SendTo("/topic/round3-websocket")
    public nextquestionr3 sendQuestion() throws InterruptedException {
        //allround3 = r3service.getAllwithImage();;
        System.out.println("HELLÔ");
        nextquestionr3 next = new nextquestionr3();
        round3 temp =(round3) allround3.get(i4).get("round3");

        if(i4<6){
            i4++;
            round3 temp1 =(round3) allround3.get(i4).get("round3");
            next.setQuestion(temp1.getQuestion());
            next.setImage((String) allround3.get(i4).get("image"));
        }

        else{
            next.setQuestion("END");
            i4=0;
            System.out.println(i4);
        }
        return next;
    }

    @MessageMapping("/pushr3_2")
    public void sendAnswer(String answer,@Header("Authorization") String authorization) throws InterruptedException {
        System.out.println(authorization);
        allanswer.put(jwt.extractUsername(authorization.substring(7)),answer);System.out.println(allanswer);
    }

    @MessageMapping("/pushr3_3")
    @SendTo("/topic/round3-websocket")
    public int sendAllAnswer(){
        System.out.println("HELLÔ");
        return 1;
    }

}
