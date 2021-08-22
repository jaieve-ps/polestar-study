package com.home.study.fileio.jumpToJava;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class FileRead {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\MSI\\Desktop\\fileout.txt"));
            while(true) {
                String line = bufferedReader.readLine();
                if (line == null) break;
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
