package com.example.olympiabackend.controller.competition;

import com.example.olympiabackend.model.questions.round1;
import com.example.olympiabackend.storage.sample.nextquestionr1;
import com.example.olympiabackend.service.questionService.round1.round1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class round1socket {

    @Autowired
    round1Service r1service;

    public static int i=0;
    @MessageMapping("/pushr1")
    @SendTo("/topic/round1-websocket")
    public nextquestionr1 sendMessage(Integer answer) {
        List<round1> allround1 = r1service.getAll();
        nextquestionr1 ques = new nextquestionr1();
        int correct = allround1.get(i).getIdanswer().getIscorrect();
        if(correct==answer){
            ques.setCheck(1);
        }else{
            ques.setCheck(0);
        }
        System.out.println(i);
        if(i<15){
            i++;
            ques.setQuestion(allround1.get(i).getQuestion());
            ques.setA(allround1.get(i).getIdanswer().getA());
            ques.setB(allround1.get(i).getIdanswer().getB());
            ques.setC(allround1.get(i).getIdanswer().getC());
            ques.setD(allround1.get(i).getIdanswer().getD());
            System.out.println(allround1.size());
        }
        else{
            ques.setQuestion("END");
            i=0;
        }
        System.out.println(ques);
        return ques;
    }



}
