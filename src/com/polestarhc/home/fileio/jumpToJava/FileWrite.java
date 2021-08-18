package com.polestarhc.home.fileio.jumpToJava;

import java.io.*;

public class FileWrite {
    public static void main(String[] args) {
        PrintWriter pw = null;
        PrintWriter pw2 = null;
        try {
            pw = new PrintWriter("C:\\Users\\MSI\\Desktop\\fileout.txt");
            for(int i=1; i<11; i++) {
                String data = i+" 번째 줄입니다.\r\n";
                pw.write(data);
            }
            pw.close();

            pw2 = new PrintWriter(new FileWriter("C:\\Users\\MSI\\Desktop\\fileout.txt", true));
            for(int i=11; i<21; i++) {
                String data = i+" 번째 줄입니다.";
                pw2.println(data);
            }
            pw2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
