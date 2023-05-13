package com.example.olympiabackend.serviceImpl.questionServiceImpl.round4;

import com.example.olympiabackend.model.questions.answer_round1;
import com.example.olympiabackend.model.questions.answer_round4;
import com.example.olympiabackend.model.questions.round1;
import com.example.olympiabackend.model.questions.round4;
import com.example.olympiabackend.model.topic;
import com.example.olympiabackend.repository.questionRepository.topicRepository;
import com.example.olympiabackend.service.questionService.round4.excelUploadRound4;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class excelUploadRound4Impl implements excelUploadRound4 {
    @Autowired
    topicRepository topicRe;

    @Override
    public boolean validate(MultipartFile file) {
        if(file.getContentType().equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")){
            return true;
        }
        else return false;
    }

    @Override
    public List<round4> uploaddata(InputStream inputstream) {

        List<round4> r_list = new ArrayList<>();

        XSSFWorkbook workbook = null;
        try {
            workbook = new XSSFWorkbook(inputstream);
            XSSFSheet sheet = workbook.getSheet("round4");

            for (Row row:sheet) {
                round4 r4 = new round4();
                answer_round4 ar4  = new answer_round4();
                int cellIndex = 0;
                Iterator<Cell> cellIterator = row.iterator();
                DataFormatter formatter = new DataFormatter();
                while (cellIterator.hasNext()){
                    Cell cell = cellIterator.next();
                    //System.out.println(cell.getStringCellValue());
                    //String value = cell.getStringCellValue();
                    //System.out.println(cell.getStringCellValue());
                    if(cellIndex==0) {
                        String value = formatter.formatCellValue(row.getCell(0));
                        r4.setQuestion(value);
                        //System.out.println(value);
                    }
                    else if(cellIndex==1) {
                        String value = formatter.formatCellValue(row.getCell(1));
                        r4.setSource(value);
                    }
                    else if(cellIndex==2) {
                        double value = row.getCell(2).getNumericCellValue();
                        //System.out.println(value);
                        r4.setLevel1((int)value);
                    }
                    else if(cellIndex==3){
                        double value = row.getCell(3).getNumericCellValue();
                        topic t = topicRe.findById((int) value).get();
                        r4.setTopic(t);
                    }
                    else if(cellIndex==4) {
                        String value = formatter.formatCellValue(row.getCell(4));
                        System.out.println(value+" "+r4.getSource());
                        ar4.setAnswer(value);
                    }
                    cellIndex++;
                }
                r4.setIdanswer(ar4);
                r_list.add(r4);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return r_list;

    }
}
