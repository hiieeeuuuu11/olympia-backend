package com.example.olympiabackend.service.questionService.round1;

import com.example.olympiabackend.model.questions.round1;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

public interface excelUploadRound1 {
    public boolean validate(MultipartFile file);
    public List<round1> uploaddata(InputStream inputstream);
}
