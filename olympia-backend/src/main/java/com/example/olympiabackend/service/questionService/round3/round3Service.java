package com.example.olympiabackend.service.questionService.round3;

import com.example.olympiabackend.model.questions.round1;
import com.example.olympiabackend.model.questions.round3;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface round3Service {
    public round3 saveinfo(round3 r3);
    public List<round3> getAll();
    public List<Map<String, Object>> getAllwithImage();
}
