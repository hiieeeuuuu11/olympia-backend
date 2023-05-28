package com.example.olympiabackend.controller.competition;

import com.example.olympiabackend.model.questions.round3;
import com.example.olympiabackend.service.questionService.round3.round3Service;
import com.example.olympiabackend.storage.sample.nextquestionr3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class round3socket {
    @Autowired
    round3Service r3service;

    public static int i4=0;
    @MessageMapping("/pushr3")
    @SendTo("/topic/round3-websocket")
    public nextquestionr3 sendMessageround3(String answer){
        System.out.println("HELLÔ");
        nextquestionr3 next = new nextquestionr3();
        List<Map<String, Object>> allround3 = r3service.getAllwithImage();
        round3 temp =(round3) allround3.get(i4).get("round3");

        String correct = temp.getIdanswer().getAnswer();

        if(correct.equals(answer)){
            next.setCheck(1);
        }else{
            next.setCheck(0);
        }
        if(i4<allround3.size()){
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

}
