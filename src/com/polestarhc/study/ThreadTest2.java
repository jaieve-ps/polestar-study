package com.polestarhc.study;

import java.util.List;

class ThreadTest2 implements Runnable{
    private List<Study> studyList;

    public ThreadTest2(List<Study> studyList) {
        this.studyList = studyList;
    }

    @Override
    public void run() {
        studyList = this.studyList;
        for (int i = 0; i < 100; i++) {
            int index = studyList.size() - i;
            Study study = studyList.get(i);
            study.setPatiendId(String.valueOf(index)+"B");
            study.setPatientName(study.getPatientName()+"B");
            System.out.println(study.toString());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
