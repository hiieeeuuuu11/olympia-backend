package com.example.olympiabackend.controller.competition;

import com.example.olympiabackend.model.User;
import com.example.olympiabackend.model.questions.round2;
import com.example.olympiabackend.model.questions.suggest_quest;
import com.example.olympiabackend.storage.sample.nextquestionr2;
import com.example.olympiabackend.service.questionService.round2.round2Service;
import com.example.olympiabackend.storage.sample.nextquestionr2_2;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Configuration
public class round2socket {

    @Autowired
    round2Service r2service;

    public Map<String,String> allanswer = new HashMap<>();


//    @Bean
//    public Map<String,Object> All(){
//        round2 r2 = r2service.getOne(i);
//        List<suggest_quest> suggest = r2.getSuggest();
//        Map<String,Object> allr2 = r2service.getOneWithImage(r2);
//        return allr2;
//    }

//    round2 r2 = r2service.getOne(1);
//    List<suggest_quest> suggest = r2.getSuggest();
//    Map<String,Object> allr2 = r2service.getOneWithImage(r2);

    public static int i2=0;
    @MessageMapping("/pushr2_1")
    @SendTo("/topic/round2-websocket")
    public nextquestionr2 chooseQuestion(int number){
        round2 r2 = r2service.getOne(i2);
        List<suggest_quest> suggest = r2.getSuggest();
        Map<String,Object> allr2 = r2service.getOneWithImage(r2);
        switch (number){
            case 1:
                return new nextquestionr2(suggest.get(0).getQuestion(),suggest.get(0).getLength1(),1);
            case 2:
                return new nextquestionr2(suggest.get(1).getQuestion(),suggest.get(1).getLength1(),1);
            case 3:
                return new nextquestionr2(suggest.get(2).getQuestion(),suggest.get(2).getLength1(),1);
            case 4:
                return new nextquestionr2(suggest.get(3).getQuestion(),suggest.get(3).getLength1(),1);
        }
        return null;
    }

    @MessageMapping("/pushr2_2")
    public void sendAnswer(String answer){
        System.out.println(allanswer);
    }


    @MessageMapping("/pushr2_3")
    @SendTo("/topic/round3-websocket")
    public int sendAllAnswer(){
        return 1;
    }


}
