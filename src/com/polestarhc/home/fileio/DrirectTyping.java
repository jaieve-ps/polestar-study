package com.polestarhc.home.fileio;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class DrirectTyping {
    static File file = new File("C:\\Users\\MSI\\Desktop\\Test.txt");

    public static void inputString(String[] args) {
        try {
            if(file.exists()){
                Desktop.getDesktop().edit(file);
            } else {
                file.createNewFile();
                Desktop.getDesktop().edit(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
