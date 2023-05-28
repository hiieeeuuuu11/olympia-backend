package com.example.olympiabackend.serviceImpl.questionServiceImpl.round3;

import com.example.olympiabackend.model.questions.round1;
import com.example.olympiabackend.model.questions.round3;
import com.example.olympiabackend.model.questions.round3;
import com.example.olympiabackend.repository.questionRepository.round1Repository;
import com.example.olympiabackend.repository.questionRepository.round3Repository;
import com.example.olympiabackend.service.questionService.round1.excelUploadRound1;
import com.example.olympiabackend.service.questionService.round3.round3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Service
public class round3ServiceImpl implements round3Service {

    @Autowired
    round3Repository r3rep;

    @Override
    public round3 saveinfo(round3 r3) {
        r3rep.save(r3);
        return r3;
    }

    @Override
    public List<round3> getAll() {
        return (List<round3>) r3rep.findAll();
    }

    @Override
    public List<Map<String, Object>> getAllwithImage() {
        List<round3> allround3 = r3rep.findAll();
        if (allround3.isEmpty()) {
            return null;
        }
        List<Map<String, Object>> responseList = new ArrayList<>();
        for (round3 round3Object : allround3) {
            Map<String, Object> responseMap = new HashMap<>();
            responseMap.put("round3", round3Object);

            String imagePath = "E:/OLYMPIA/round4/" + round3Object.getSource();
            System.out.println(imagePath);
            String base64Image = "";
            if (round3Object.getSource() != null) {
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
