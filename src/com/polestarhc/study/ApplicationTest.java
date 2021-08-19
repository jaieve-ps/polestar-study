package com.polestarhc.study;

import com.polestarhc.home.fileio.Hospital;

import java.util.ArrayList;
import java.util.List;

public class ApplicationTest {
    public ApplicationTest() {
    }

    public static void main(String[] args) {
        List<Study> studyList = new ArrayList<Study>();

        for (int i = 0; i < 1000; i++) {
            Study study = new Study();
            study.setPatiendId("P"+String.valueOf(i));
            study.setPatientName("홍서연");
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

//        System.out.println("스레드 종료");
        // thread.start(); // 진짜 스레드가 생성이 되고, 해당 스레드에 실린 것이 스레드로 실행되는 것.
        // thread.run(); // JVM이 객체를 실행시키는 것. != 스레드 호출

    }

    public List<IExcel> makeStudyList() {
        List<IExcel> list = new ArrayList<IExcel>();
        for (int i = 0; i < 1000; i++) {
            Study study = new Study();
            study.setPatiendId("P"+String.valueOf(i));
            study.setPatientName("홍서연");
            list.add(study);
        }
        return list;
    }

    public List<IExcel> makeHospitalList() {
        List<IExcel> list = new ArrayList<IExcel>();
        for (int i = 0; i < 1000; i++) {
            Hospital hospital = new Hospital();
            hospital.setHospitalName("OO병원"+i);
            hospital.setHospitalAbbr("OO"+i);
            hospital.setHospitalArea("서울");
            hospital.setHospitalAddress("서울특별시 서초구");
            hospital.setBedCount(50);
            list.add(hospital);
        }
        return list;
    }
}
