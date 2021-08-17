package com.polestarhc.home.fileio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderEx {
    public static void main(String[] args) {
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader("src/com/polestarhc/home/fileio/InputStreamEx.java");
            br = new BufferedReader(fr);

            String txt = null;
            while((txt=br.readLine()) != null) {
                System.out.println(txt);
            }
        } catch (IOException e ){

        } finally {
            try {
                fr.close();
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
