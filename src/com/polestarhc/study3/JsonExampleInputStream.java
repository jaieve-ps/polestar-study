package com.polestarhc.study3;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.polestarhc.study.Study;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class JsonExampleInputStream {

    public static void main(String[] args) {
        JsonExampleInputStream jsonExample = new JsonExampleInputStream();
        try {
            jsonExample.writeFile("jsonTest.json");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
//        jsonExample.readFile("jsonTest.json");
        jsonExample.readFile("fr.txt");
    }

    private void writeFile(String path) throws JsonProcessingException {
        // 1. 파일 생성
        File file = null;
        file = new File("textFiles/"+ path);
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
        FileInputStream fis = null;
        try {
            FileOutputStream fos = new FileOutputStream(new File("isJson.json"));
            fis = new FileInputStream(new File("textFiles/"+path));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            BufferedInputStream bis = new BufferedInputStream(fis);
            int data = 0;
            byte[] buf = new byte[8];
            String obj = null;
            while((data=bis.read(buf))!=-1) {
                System.out.println("byte size: " + data+ ", data: " + new String(buf,"utf-8"));
            }
            fis.close();
            bis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
//        Study study = objectMapper.readValue(studyJson, Study.class);
    }
}