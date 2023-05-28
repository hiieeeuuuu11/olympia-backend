package com.example.olympiabackend.service.questionService.round4;

import com.example.olympiabackend.model.questions.round1;
import com.example.olympiabackend.model.questions.round4;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface round4Service {
    public round4 saveinfo(round4 r4);
    public List<round4> saveinfoexcel(MultipartFile file);
    public List<round4> getAll();
    public List<Map<String, Object>> getAllwithImage();
}
