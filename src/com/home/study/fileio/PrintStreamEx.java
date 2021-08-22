package com.home.study.fileio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamEx {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("print.txt", true);
            PrintStream ps = new PrintStream(fos);
            ps.println("홍길동");
            ps.println(1111);
            ps.println(true);
            ps.println(3.14);
            ps.flush();
            ps.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
