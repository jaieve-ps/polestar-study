package com.polestarhc.study2;

import java.io.*;

public class FileCopier {
    private String originFile;
    private String newFile;

    public static void main(String[] args) throws IOException {
        FileCopier fc = new FileCopier();
        String originFile = "fr.txt";
        String newFile = "fr_copy.txt";
        fc.copyFile(originFile, newFile);
    }

    private void copyFile(String originfileName, String newFileName){
        File originFile = new File(originfileName);
        String FILEPATH = originFile.getAbsolutePath().replace(originfileName,"");
        File newFile = new File(FILEPATH + newFileName);
        newFile.getParentFile().mkdirs(); //
        boolean status = newFile.exists();
//        newFile.mkdirs(); //디렉터리 있는지 확인하고 false면 현재 위치에서 상위디렉터리 생성해줌
        if(status){ //복사한 파일 생성 확인
            System.out.println("디렉토리 생성 성공");
            System.out.println("FileReader.readFile : " + status +", " + newFile.getAbsolutePath());
        }

        // File read
        try {
            FileInputStream fis = new FileInputStream(originFile);
            FileOutputStream fos = new FileOutputStream(newFile);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            int data = 0;
            byte[] buf = new byte[fis.available()]; //740
            while((data=fis.read(buf))!=-1){
                baos.write(buf);
                System.out.println("data: "+data);
                fos.write(baos.toByteArray());
            }
            fis.close();
            fos.close();
            baos.close();
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("FileReader.");
        }
    }
}
