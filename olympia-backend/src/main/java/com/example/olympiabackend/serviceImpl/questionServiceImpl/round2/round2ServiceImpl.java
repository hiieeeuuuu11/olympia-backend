package com.example.olympiabackend.serviceImpl.questionServiceImpl.round2;

import com.example.olympiabackend.model.questions.round1;
import com.example.olympiabackend.model.questions.round2;
import com.example.olympiabackend.model.questions.round4;
import com.example.olympiabackend.repository.questionRepository.round1Repository;
import com.example.olympiabackend.repository.questionRepository.round2Repository;
import com.example.olympiabackend.service.questionService.round2.round2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Service
public class round2ServiceImpl implements round2Service {

    @Autowired
    round2Repository r2rep;

    @Override
    public round2 getOne(int id) {
        return r2rep.findById(id).get();
    }

    @Override
    public Map<String, Object> getOneWithImage(round2 t) {
            Map<String, Object> response = new HashMap<>();
            response.put("round2",t);

            String imagePath = "E:/OLYMPIA/Round2/" + t.getPicture_source();
            System.out.println(imagePath);
            String base64Image = "";
            if (t.getPicture_source() != null) {
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
            response.put("image", base64Image);
        return response;
    }

    @Override
    public List<round2> getAll() {
        return (List<round2>) r2rep.findAll();
    }
}
