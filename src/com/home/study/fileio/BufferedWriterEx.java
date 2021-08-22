package com.home.study.fileio;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;

public class BufferedWriterEx {
    public static void main(String[] args) {
        try  {
            FileWriter fw = new FileWriter("test4.txt");
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("A");
            char[] buf = {'B', 'C', 'D'};
            bw.write(buf);
            bw.write(buf, 1,2);
            bw.write("저는 홍서연 입니다.");

            bw.flush();
            bw.close();
        } catch (IOException e ){
            System.out.println(e.getMessage());
        }
    }
}
