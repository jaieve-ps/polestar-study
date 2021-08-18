package com.polestarhc.home.fileio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamEx {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            FileInputStream fis = new FileInputStream("src/com/polestarhc/home/fileio/InputStreamEx.java");
            int data = 0;
            byte[] buf = new byte[fis.available()];
            // fis.available() 메서드를 이용해 해당 파일 읽기 가능 바이트수를 배열 크기로 지정
            while((data=fis.read(buf)) != -1 ){
                System.out.println((char)data);
            }
        } catch (IOException e) {

        }
    }
}
