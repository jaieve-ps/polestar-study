package com.home.study.fileio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamEx3 {
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("src/com/polestarhc/home/fileio/InputStreamEx.java");
            int data = 0;
            byte[] buf = new byte[fis.available()];
            while ((data = fis.read(buf, 0, buf.length)) != -1) {
                System.out.print(new String(buf, 0, data));
            }
        } catch (IOException e) {
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
