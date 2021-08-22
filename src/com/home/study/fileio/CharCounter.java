package com.home.study.fileio;

import java.util.Scanner;

public class CharCounter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("메모장에 자소서를 입력하시면 글자수를 세어줍니다.");
        System.out.println("저장이 끝나면 저장하시고 창을 닫아주세요.");
        DrirectTyping.inputString(args);

        System.out.println("글자수를 세어드릴까요? 숫자 1을 눌려주세요.");
        int yes = scan.nextInt();
        if (yes == 1) {
            FileReadChar.countChar(args);
        } else {
            System.out.println("숫자 1을 누르지 않아서 종료됩니다.");
        }
        scan.close();
    }
}
