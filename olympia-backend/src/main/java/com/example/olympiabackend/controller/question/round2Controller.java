package com.example.olympiabackend.controller.question;

import com.example.olympiabackend.model.questions.round1;
import com.example.olympiabackend.model.questions.round2;
import com.example.olympiabackend.service.questionService.round1.round1Service;
import com.example.olympiabackend.service.questionService.round2.round2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/question2")
public class round2Controller {

    @Autowired
    round2Service r2service;

    @GetMapping("/getallr2")
    public List<round2> getAll(){
        List<round2> allround2 = r2service.getAll();
        return allround2;
    }




}
