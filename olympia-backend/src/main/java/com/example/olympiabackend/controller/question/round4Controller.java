package com.example.olympiabackend.controller.question;

import com.example.olympiabackend.model.questions.round1;
import com.example.olympiabackend.model.questions.round4;
import com.example.olympiabackend.service.questionService.round1.round1Service;
import com.example.olympiabackend.service.questionService.round4.round4Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.*;

@CrossOrigin
@RestController
@RequestMapping("/question4")
public class round4Controller {
    @Autowired
    round4Service r4service;

    @PostMapping("/excel")
    public ResponseEntity<List<round4>> saveInfo(@RequestBody MultipartFile file){
        List<round4> inf = r4service.saveinfoexcel(file);
        return new ResponseEntity(inf, HttpStatus.OK);
    }

    @PostMapping("/r")
    public ResponseEntity<round1> saveInfo(@RequestBody round4 r4){
        round4 inf = r4service.saveinfo(r4);
        //System.out.println(r1);
        return new ResponseEntity(inf, HttpStatus.OK);
    }

    @GetMapping("/getallr4")
    public ResponseEntity<List<Map<String, Object>>> getAll() {
        if (r4service.getAllwithImage()== null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(r4service.getAllwithImage());
    }


}
