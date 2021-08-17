package com.polestarhc.home.fileio;

import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamEx {
    public static void main(String[] args) {
        try {
            OutputStream out = System.out;
            out.write('a');
            out.write('b');
            out.write('c');
            out.write('1');
            out.write('2');
            out.write('3');
            out.write('가'); // OutputStream은 바이트스트림이기때문에 2byte인 한글은 깨진다.
            out.write('나'); // 문자 기반 출력 스트림 writer를 사용하면 해결
            out.write('다');
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ;
    }
}
