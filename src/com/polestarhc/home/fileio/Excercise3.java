package com.polestarhc.home.fileio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Excercise3 {
    public static void main(String[] args) {
        FileReader filereader = null;
        BufferedReader breader = null;

        try {
            filereader = new FileReader("src/com/polestarhc/home/fileio/InputStreamEx.java");
            breader = new BufferedReader(filereader);

            String txt = null;
            while((txt=breader.readLine()) != null) {
                System.out.println(txt);
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        } finally {
            try {
                filereader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
