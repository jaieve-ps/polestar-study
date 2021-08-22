package com.home.study.observerScore;

import java.util.List;

public class DataSheetView implements Observer{
    private final ScoreRecord scoreRecord;
    private int viewCount;

    public DataSheetView(ScoreRecord scoreRecord, int viewCount) {
        this.scoreRecord = scoreRecord;
        this.viewCount = viewCount;
    }

    @Override
    public void update() {
        List<Integer> record = scoreRecord.getScoreRecord(); // 점수 조회
        displayScores(record, viewCount); // 조회된 점수를 viewCount만큼 출력
    }

    private void displayScores(List<Integer> record, int viewCount) {
        System.out.println("List of "+ viewCount + " entires: ");
        for (int i = 1; i <= viewCount && i <= record.size(); i++) {
            System.out.print((i*10) + " ");
        }
        System.out.println("");
    }
}
