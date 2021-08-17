package com.polestarhc.study2;

import java.io.*;

public class Filereader {

    public static void main(String [] args) {
        Filereader fr = new Filereader();
        fr.readFile();
    }
    private void readFile() {
        File file = new File("./textFolder/fr.txt");
        boolean status = file.exists();
        System.out.println("FileReader.readFile : " + status +", " + file.getAbsolutePath());

        // 1. 파일안의 내용을 읽으시오
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bytesIn = new byte[8];
            int read = 0;
            long size = 0;
            String value = null;
            while ((read = fileInputStream.read(bytesIn)) != -1) {
                byteArrayOutputStream.write(bytesIn, 0, read);
                System.out.println("read : " +read);
                value = new String(byteArrayOutputStream.toByteArray());
                System.out.println("value : " +value);
                size+=read;
            }
            System.out.println(" 1 " + read);
            System.out.println(" 2 " + size);
            System.out.println(" 3 " + value);
            System.out.println(" ");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("FileReader.readFile " + file.getName() +" 파일이 없습니다.");
        } catch (IOException e) {
            System.out.println("FileReader.readFile " + file.getName() +" read 오류.");
            e.printStackTrace();
        }
        // 2. 읽은 내용을 출력하시오
        // 3. 파일2로 복사해서 내용을 넣으시오
    }

}