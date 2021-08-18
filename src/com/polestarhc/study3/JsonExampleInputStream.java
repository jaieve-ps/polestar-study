package com.polestarhc.study3;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.polestarhc.study.Study;

import java.io.*;
import java.util.*;


public class JsonExampleInputStream {

    public static void main(String[] args) {
        JsonExampleInputStream jsonExample = new JsonExampleInputStream();
        try {
            jsonExample.writeFile("jsonTest.json");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        jsonExample.readFile("jsonTest.json");
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
        for (int i = 0; i < maximum;i++) {
            Study study = new Study();
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
        ObjectMapper objectMapper = new ObjectMapper();
        JsonMapper jsonMapper = new JsonMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        try {
            fis = new FileInputStream("textFiles/"+path);
            BufferedInputStream bis = new BufferedInputStream(fis);
            int data = 0;
            byte[] buf = new byte[bis.available()];
            while((data=bis.read(buf))!=-1) {
                System.out.println("byte size: " + data+ ", data: " + new String(buf));
            }
            fis.close();
            bis.close();
            // byte[] -> List<study>
            List<Study> studyListGot= objectMapper.readValue(buf, new TypeReference<>() {
            });
            System.out.println(studyListGot.getClass()); //ArrayList
            System.out.println(studyListGot.get(0).getClass()); // Study
            // print study instance to console
            for (Study study:studyListGot) {
                System.out.println(study.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}