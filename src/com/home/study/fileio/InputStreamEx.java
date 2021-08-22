package com.home.study.fileio;

import java.io.IOException;
import java.io.InputStream;

public class InputStreamEx {
    public static void main(String[] args) {
        try {
            // 바이트기반 데이터 : InputStream, OutStream -> File~, Data~, Object~
            // 문자 단위 데이터 : Reader, Writer -> File~, InputStreamREader/Writer, Buffered~
            InputStream in = System.in;
            int data = 0;
            while(((data=in.read()) != -1)) {
                System.out.println((char) data);
                // 한글처리 테스트
            }
        } catch (IOException e){

        }
    }
}
