package com.example.olympiabackend.controller.question;

import com.example.olympiabackend.model.questions.round3;
import com.example.olympiabackend.service.questionService.round3.round3Service;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/question3")
public class round3Controller {
    @Autowired
    round3Service r3service;

    List<round3> r3 ;

    @PostMapping("/r")
    public ResponseEntity<round3> saveInfo(@RequestBody round3 r3){
        round3 inf = r3service.saveinfo(r3);
        //System.out.println(r3);
        return new ResponseEntity(inf, HttpStatus.OK);
    }

    @GetMapping("/getallr3")
    public List<round3> getAll(){
        List<round3> allround3 = r3service.getAll();
        return allround3;
    }


}
