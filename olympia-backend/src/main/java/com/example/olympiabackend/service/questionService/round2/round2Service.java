package com.example.olympiabackend.service.questionService.round2;

import com.example.olympiabackend.model.questions.round1;
import com.example.olympiabackend.model.questions.round2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public interface round2Service {
    public round2 getOne(int id);
    public Map<String, Object> getOneWithImage(round2 t);
    public List<round2> getAll();
}
