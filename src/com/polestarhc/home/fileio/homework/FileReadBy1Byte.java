package com.polestarhc.home.fileio.homework;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;

public class FileReadBy1Byte {
    public static void main(String[] args) throws Exception {
        FileReadBy1Byte fileReadBy1Byte = new FileReadBy1Byte();
//        fileReadBy1Byte.readByte("fr.txt");
//        fileReadBy1Byte.readByte("image.jpg");
//        fileReadBy1Byte.readByte("PACS별연동구분정보.xlsx");
        fileReadBy1Byte.readByte("협조기안방법_최종.pdf");
    }

    private void readByte(String path) throws Exception {
        FileInputStream fis = new FileInputStream("testfileForFileIO/"+path);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        String string = null;
        byte[] aByte = new byte[1];
        for (int i = 0; i < 100; i++){
            baos.write(aByte);
            byte[] byteArraytoPrint = baos.toByteArray();
            System.out.print(i+" 번째 Byte Format: "+ byteArraytoPrint.toString() + i +" 번째 Ascii Format: ");
            System.out.print((int)byteArraytoPrint[0]);
            System.out.println(", Char Format: "+(char)byteArraytoPrint[0]);
            baos.reset();
            aByte = new byte[1];
        }
    }
}
