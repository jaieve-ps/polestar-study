package com.polestarhc.study;

import java.util.ArrayList;

public class ApplicationTest {
    public static void main(String[] args) {
        ArrayList<Study> studyList = new ArrayList<Study>();

        for (int i = 0; i < 1000; i++) {
            Study study = new Study();
            study.setPatiendId("P"+String.valueOf(i));
            study.setPatientName("홍길동");
            studyList.add(study);
        }

        ThreadTest1 threadTest1 = new ThreadTest1(studyList);
        ThreadTest2 threadTest2 = new ThreadTest2(studyList);

        Thread thread1 = new Thread(threadTest1);
        Thread thread2 = new Thread(threadTest2);

        // 아래의 코드는 위와 똑같은 결과를 보인다.
//        Thread thread1 = new Thread(new ThreadTest1(studyList));
//        Thread thread2 = new Thread(new ThreadTest2(studyList));

        thread1.start();
        thread2.start();

    }
}
