package com.home.study.fileio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamEx2 {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            FileInputStream fis = new FileInputStream("src/com/polestarhc/home/fileio/InputStreamEx.java");
            int data = 0;
            byte[] buf = new byte[fis.available()];
            // fis.available() 메서드를 이용해 해당 파일 읽기 가능 바이트수를 배열 크기로 지정
            while((data=fis.read(buf)) != -1 ){
                // read(byte[] b) : 실제파일에서 읽어들인 내용은 buf에 저장되고, 실제 읽은 바이트수를 리턴
                System.out.print(new String(buf,0,data));
                // new String() : 바이트 배열과 0부터 바이트 수만틈 문자열로 변환
            }
        } catch (IOException e) {

        }
    }
}
