package com.polestarhc.home.fileio;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderEx {
    public static void main(String[] args) {
        FileReader fr = null;
        try {
            fr = new FileReader("src/com/polestarhc/home/fileio/InputStreamEx.java");
            int data = 0;
            while((data = fr.read()) != -1) {
                System.out.print((char)data);
            }
        } catch (IOException e) {

        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

