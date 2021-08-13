package com.polestarhc.study;

import java.util.List;

class ThreadTest1 implements Runnable{
    private List<Study> studyList;

    public ThreadTest1(List<Study> studyList) {
        this.studyList = studyList;
    }

    @Override
    public void run() {
        studyList = this.studyList;
        for (int i = 0; i < 100; i++) {
            int index = i + 1;
            Study study = studyList.get(i);
            study.setPatiendId(String.valueOf(index)+"A");
            study.setPatientName(study.getPatientName()+"A");
            System.out.println(study.toString());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
