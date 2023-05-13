package com.example.olympiabackend.service.questionService.round1;

import com.example.olympiabackend.model.questions.answer_round1;
import com.example.olympiabackend.model.questions.round1;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface round1Service {
    public round1 saveinfo(round1 r1);
    public List<round1> saveinfoexcel(MultipartFile file);
    public List<round1> getAll();

}
