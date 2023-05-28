package com.example.olympiabackend.serviceImpl.questionServiceImpl.round4;

import com.example.olympiabackend.model.questions.round1;
import com.example.olympiabackend.model.questions.round4;
import com.example.olympiabackend.repository.questionRepository.round1Repository;
import com.example.olympiabackend.repository.questionRepository.round4Repository;
import com.example.olympiabackend.service.questionService.round1.excelUploadRound1;
import com.example.olympiabackend.service.questionService.round4.excelUploadRound4;
import com.example.olympiabackend.service.questionService.round4.round4Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.*;

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

    @Override
    public List<round4> getAll() {
        return r4rep.findAll();
    }

    @Override
    public List<Map<String, Object>> getAllwithImage() {
        List<round4> allRound4 = r4rep.findAll();
        if (allRound4.isEmpty()) {
            return null;
        }
        List<Map<String, Object>> responseList = new ArrayList<>();
        for (round4 round4Object : allRound4) {
            Map<String, Object> responseMap = new HashMap<>();
            responseMap.put("round4", round4Object);

            String imagePath = "E:/OLYMPIA/Round4/" + round4Object.getSource();
            System.out.println(imagePath);
            String base64Image = "";
            if (round4Object.getSource() != null) {
                try {
                    BufferedImage image = ImageIO.read(new File(imagePath));
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    ImageIO.write(image, "png", baos);
                    base64Image = Base64.getEncoder().encodeToString(baos.toByteArray());
                } catch (IOException e) {
                    //System.out.println("DEO DUOC");
                    e.printStackTrace();
                }
            } else {
                base64Image = "No image available";
            }
            responseMap.put("image", base64Image);
            responseList.add(responseMap);
        }
        return responseList;
    }


}
