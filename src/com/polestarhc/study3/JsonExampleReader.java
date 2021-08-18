package com.polestarhc.study3;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.polestarhc.study.Study;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class JsonExampleReader {

    public static void main(String[] args) {
        JsonExampleReader jsonExample = new JsonExampleReader();
        try {
//            jsonExample.writeFile("jsonTest.txt");
            jsonExample.writeFile("jsonTest.json");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        jsonExample.readFile("jsonTest.json");
    }

    private void writeFile(String path) throws JsonProcessingException {
        // 1. 파일 생성
        File file = null;
        file = new File("textFiles" +"/"+ path);
        System.out.println(file);
        if (!file.getParentFile().mkdirs()) {
            System.out.println("디렉토리 생성 성공");
            System.out.println("file name:"+file.getName()+", file Absolute Path :" + file.getAbsolutePath());
        }

        // 2. Study 객체 -> JSON -> List<string>에 담기
        JsonMapper jsonMapper = new JsonMapper();
        jsonMapper.enable(SerializationFeature.INDENT_OUTPUT);

        int maximum = 100;
        List<Study> studyList = new ArrayList<Study>();
        Study study = new Study();
        for (int i = 0; i < maximum;i++) {
            study.setPatiendId("S" + i);
            study.setPatientName("이재용");
            studyList.add(study);
        }
        String jsonfile = jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(studyList);

        // 3. String을 파일에 담아 저장
        try {
            FileWriter fw = new FileWriter(file);
            fw.write(jsonfile);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void readFile(String path) {
        File file = new File("textFiles/"+path);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            FileReader fr = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fr);

            String data = null;
            String json = null;
            while((data=bufferedReader.readLine())!=null) {
                json += data;
            }
            System.out.println(json);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        Study study = objectMapper.readValue(studyJson, Study.class);
    }
}