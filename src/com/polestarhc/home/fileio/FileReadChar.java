package com.polestarhc.home.fileio;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReadChar {

    public static void countChar(String[] args) {
        int charChar = 0;
        int charCnt = 0;
        int spaceCnt = 0;

        try {
            FileReader fr = new FileReader("C:\\Users\\MSI\\Desktop\\Test.txt");
            while((charChar = fr.read()) != -1) {
                if(charChar == 32 ) {spaceCnt++;}
                if(charChar != 32 ) {charCnt++; }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("잘못된 입출력입니다.");
        }
        System.out.print("파일 속 공백 숫자 : " + spaceCnt);
        System.out.print("\n파일 속 공백을 제외한 문자의 숫자는 : " + charCnt);
        System.out.print("\n파일 속 공백을 포함한 문자의 숫자는 : " + (spaceCnt+charCnt));
    }
}
