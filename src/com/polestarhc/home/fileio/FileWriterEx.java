package com.polestarhc.home.fileio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterEx {
    public static void main(String[] args) {
        try {
            FileWriter fw = new FileWriter("test3.txt");
            // 문자 하나 출력
            fw.write('A');
            // 문자배열 출력
            char[] buf = {'B', 'C', 'D'};
            fw.write(buf);
            // 문자 배열 off부터 len개수만큼 출력
            fw.write(buf,1,2);
            // 문자열 출력
            fw.write("저는 홍서연입니다.");

            fw.flush();
            fw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
