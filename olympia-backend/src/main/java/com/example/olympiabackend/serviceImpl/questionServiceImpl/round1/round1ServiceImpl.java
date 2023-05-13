package com.example.olympiabackend.serviceImpl.questionServiceImpl.round1;

import com.example.olympiabackend.model.questions.round1;
import com.example.olympiabackend.repository.questionRepository.round1Repository;
import com.example.olympiabackend.service.questionService.round1.excelUploadRound1;
import com.example.olympiabackend.service.questionService.round1.round1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Service
public class round1ServiceImpl implements round1Service {

    @Autowired
    round1Repository r1rep;

    @Autowired
    excelUploadRound1 excelr1;

    @Override
    public round1 saveinfo(round1 r1) {
        r1rep.save(r1);
        return r1;
    }

    @Override
    public List<round1> saveinfoexcel(MultipartFile file) {
        List<round1> r1 = new ArrayList<>();

        try {
            r1 = excelr1.uploaddata(file.getInputStream());
            r1rep.saveAll(r1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return r1;

    }

    @Override
    public List<round1> getAll() {
        return (List<round1>) r1rep.findAll();
    }


}
