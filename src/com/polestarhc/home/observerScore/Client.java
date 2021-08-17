package com.polestarhc.home.observerScore;

public class Client {
    public static void main(String[] args) {
        ScoreRecord scoreRecord = new ScoreRecord();

        // 3개 까지의 점수만 출력
        DataSheetView dataSheetView = new DataSheetView(scoreRecord, 3);
        // 최대값, 최소값만 출력
        MinMaxView minMaxView = new MinMaxView(scoreRecord);

        scoreRecord.attach(dataSheetView);
        scoreRecord.attach(minMaxView);

        // 10 20 30 40 50을 추가
        for(int i = 1; i <= 5; i++) {
            int score = i * 10;
            System.out.println("Adding " + score);
            scoreRecord.addScore(score);
            //추가할 때마다 최대 4개의 점수 목록과 최대/최소값이 출력됨.
            System.out.println("");
        }
    }
}
