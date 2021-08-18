package com.polestarhc.study3;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;

import com.polestarhc.study.Study;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class JsonExample {

    public static void main(String[] args) {
        JsonExample jsonExample = new JsonExample();
        try {
            jsonExample.writeFile("jsonTest.txt");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        jsonExample.readFile("jsonTest.txt");

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
        List<String> jsonList = new ArrayList<String>();
        for (int i = 0; i < maximum;i++) {
            Study study = new Study();
            study.setPatiendId("S" + i);
            study.setPatientName("이재용");
            String stringFromJSON = jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(study)+",\n";
            jsonList.add(stringFromJSON);
        }
        System.out.println(jsonList);

        // 3. String을 파일에 담아 저장
        try {
            FileWriter fw = new FileWriter(file);
            for(String json: jsonList) {
                fw.write(json);
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void readFile(String path) {
        File file = new File("textFiles/"+path);
        try {
            FileInputStream fr = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int data = 0;
            byte[] b = new byte[1024];
            while((data=fr.read(b))!=-1) {
                System.out.println(data);
                bos.write(b);
                System.out.println(new String(bos.toByteArray()));
            }
            System.out.println(new String(b));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
