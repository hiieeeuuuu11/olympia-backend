package com.example.olympiabackend.service.questionService.round4;

import com.example.olympiabackend.model.questions.round1;
import com.example.olympiabackend.model.questions.round4;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

public interface excelUploadRound4 {
    public boolean validate(MultipartFile file);
    public List<round4> uploaddata(InputStream inputstream);
}
