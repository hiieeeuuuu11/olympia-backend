package com.example.olympiabackend.controller.competition;

import com.example.olympiabackend.model.questions.round1;
import com.example.olympiabackend.model.sample.nextquestion;
import com.example.olympiabackend.service.questionService.round1.round1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class answerController {

    @Autowired
    round1Service r1service;
    public static int i=0;
    @MessageMapping("/push")
    @SendTo("/topic/round1-websocket")
    public nextquestion sendMessage(Integer answer) {
        List<round1> allround1 = r1service.getAll();
        nextquestion ques = new nextquestion();
        int correct = allround1.get(i).getIdanswer().getIscorrect();
        if(correct==answer){
            ques.setCheck(1);
        }else{
            ques.setCheck(0);
        }
        if(i<=allround1.size()){
            i++;
            ques.setQuestion(allround1.get(i).getQuestion());
        }
        else{
            ques.setQuestion("END");
            i=0;
        }
        return ques;
    }

}
