package com.polestarhc.home.fileio.homework;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class FileOutputfor60 {
    public static void main(String[] args) {
        FileOutputfor60 func = new FileOutputfor60();
        func.runForAMinute("FileWritedFor1min.txt");
    }

    private void runForAMinute(String filename) {
        try {
            FileOutputStream fos = new FileOutputStream("testfileForFileIO/"+filename); // 파일 생성됨
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            LocalDateTime then = LocalDateTime.now();
            while (true) {
                // LOGIC
                fos.write(0);
                // TIMER
                if(ChronoUnit.MINUTES.between(then, LocalDateTime.now()) >=1) break;
            }
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
