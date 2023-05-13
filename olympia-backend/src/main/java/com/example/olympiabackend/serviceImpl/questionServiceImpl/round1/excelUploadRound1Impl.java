package com.example.olympiabackend.serviceImpl.questionServiceImpl.round1;

import com.example.olympiabackend.model.questions.answer_round1;
import com.example.olympiabackend.model.questions.round1;
import com.example.olympiabackend.model.topic;
import com.example.olympiabackend.repository.questionRepository.topicRepository;
import com.example.olympiabackend.service.questionService.round1.excelUploadRound1;
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
public class excelUploadRound1Impl implements excelUploadRound1 {

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
    public List<round1> uploaddata(InputStream inputstream) {

        List<round1> r_list = new ArrayList<>();

        XSSFWorkbook workbook = null;
        try {
            workbook = new XSSFWorkbook(inputstream);
            XSSFSheet sheet = workbook.getSheet("round1");

            for (Row row:sheet) {
                round1 r1 = new round1();
                answer_round1 ar1  = new answer_round1();
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
                        r1.setQuestion(value);
                        //System.out.println(value);
                    }
                    else if(cellIndex==1) {
                        double value = row.getCell(1).getNumericCellValue();
                        r1.setLevel1((int) value);
                    }
                    else if(cellIndex==2){
                        double value = row.getCell(2).getNumericCellValue();
                        topic t = topicRe.findById((int) value).get();
                        r1.setTopic(t);
                    }
                    else if(cellIndex==3) {
                        double value = row.getCell(3).getNumericCellValue();
                        System.out.println(value);
                        ar1.setIscorrect((int)value);
                    }
                    else if(cellIndex==4) {
                        String value = formatter.formatCellValue(row.getCell(4));
                        ar1.setA(value);
                    }
                    else if(cellIndex==5){
                        String value = formatter.formatCellValue(row.getCell(5));
                        ar1.setB(value);
                    }
                    else if(cellIndex==6){
                        String value = formatter.formatCellValue(row.getCell(6));
                        ar1.setC(value);
                    }
                    else if(cellIndex==7){
                        String value = formatter.formatCellValue(row.getCell(7));
                        ar1.setD(value);
                    }
                    cellIndex++;
                }
                r1.setIdanswer(ar1);
                r_list.add(r1);
                //System.out.println(r1);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return r_list;

    }
}
