package com.polestarhc.study;

import java.util.ArrayList;

public class ApplicationTest {
    public static void main(String[] args) {
        ArrayList<Study> studyList = new ArrayList<Study>();

        for (int i = 0; i < 1000; i++) {
            Study study = new Study();
            study.setPatiendId("S"+String.valueOf(i+1));
            study.setStudyUid(String.valueOf(i+1));
            studyList.add(study);
        }

        for (Study study : studyList) {
            System.out.println(study.toString());
        }
    }
}
