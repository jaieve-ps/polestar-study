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
        for (int i = 0; i < 1000; i++) {
            Study study = studyList.get(i);
            System.out.println("[A]"+study.toString());
        }
    }
}
