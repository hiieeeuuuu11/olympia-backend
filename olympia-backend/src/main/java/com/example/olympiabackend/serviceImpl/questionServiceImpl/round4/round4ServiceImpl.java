package com.example.olympiabackend.serviceImpl.questionServiceImpl.round4;

import com.example.olympiabackend.model.questions.round1;
import com.example.olympiabackend.model.questions.round4;
import com.example.olympiabackend.repository.questionRepository.round1Repository;
import com.example.olympiabackend.repository.questionRepository.round4Repository;
import com.example.olympiabackend.service.questionService.round1.excelUploadRound1;
import com.example.olympiabackend.service.questionService.round4.excelUploadRound4;
import com.example.olympiabackend.service.questionService.round4.round4Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class round4ServiceImpl implements round4Service {

    @Autowired
    round4Repository r4rep;

    @Autowired
    excelUploadRound4 excelr4;

    @Override
    public round4 saveinfo(round4 r4) {
        r4rep.save(r4);
        return r4;
    }

    @Override
    public List<round4> saveinfoexcel(MultipartFile file) {
        List<round4> r4 = new ArrayList<>();

        try {
            r4 = excelr4.uploaddata(file.getInputStream());
            r4rep.saveAll(r4);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return r4;

    }
}
