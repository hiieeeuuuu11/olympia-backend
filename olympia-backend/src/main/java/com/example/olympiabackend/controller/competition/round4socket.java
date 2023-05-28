package com.example.olympiabackend.controller.competition;

import com.example.olympiabackend.model.questions.round4;
import com.example.olympiabackend.storage.sample.nextquestionr4;
import com.example.olympiabackend.service.questionService.round4.round4Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class round4socket {

    @Autowired
    round4Service r4service;

    public static int i4=0;
    @MessageMapping("/pushr4")
    @SendTo("/topic/round4-websocket")
    public nextquestionr4 sendMessageRound4(String answer){
       nextquestionr4 next = new nextquestionr4();
        List<Map<String, Object>> allround4 = r4service.getAllwithImage();
        round4 temp =(round4) allround4.get(i4).get("round4");

        String correct = temp.getIdanswer().getAnswer();

        if(correct.equals(answer)){
            next.setCheck(1);
        }else{
            next.setCheck(0);
        }
        if(i4<allround4.size()){
            i4++;
            round4 temp1 =(round4) allround4.get(i4).get("round4");
            next.setQuestion(temp1.getQuestion());
            next.setImage((String) allround4.get(i4).get("image"));
        }
        else{
            next.setQuestion("END");
            i4=0;
            System.out.println(i4);
        }
        return next;
    }

}
