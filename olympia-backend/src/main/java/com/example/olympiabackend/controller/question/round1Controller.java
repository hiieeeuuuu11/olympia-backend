package com.example.olympiabackend.controller.question;

import com.example.olympiabackend.model.questions.answer_round1;
import com.example.olympiabackend.model.questions.round1;
import com.example.olympiabackend.service.questionService.round1.round1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/question1")
public class round1Controller {
    @Autowired
    round1Service r1service;

    @CrossOrigin
    @PostMapping("/excel")
    public ResponseEntity<List<round1>> saveInfo(@RequestBody MultipartFile file){
        List<round1> inf = r1service.saveinfoexcel(file);
        return new ResponseEntity(inf, HttpStatus.OK);
    }

    @PostMapping("/r")
    public ResponseEntity<round1> saveInfo(@RequestBody round1 r1){
        round1 inf = r1service.saveinfo(r1);
        //System.out.println(r1);
        return new ResponseEntity(inf, HttpStatus.OK);
    }

    @GetMapping("/getallr1")
    public List<round1> getAll(){
        List<round1> allround1 = r1service.getAll();
        return allround1;
    }


}
