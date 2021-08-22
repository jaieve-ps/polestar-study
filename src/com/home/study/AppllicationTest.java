package com.home.study;

class AppllicationTest {
    public static void main(String[] args) {
        MyThread t1 = new MyThread(); //쓰레드 생성

        // =======================
        Runnable r = new MyThread2();
        Thread t2 = new Thread(r);
//        위의 두 줄은 아래의 한 줄로 쓸 수 있음
//        Thread t2 = new Thread(new MyThread2());
        t1.start(); // 쓰레드 실행
        t2.start();
    }
}

// 1. Thread 클래스를 상속
class MyThread extends Thread{
    public void run() { // Thread 클래스의 run()을 오버라이딩
        for(int i = 0; i < 500; i++){
            System.out.print(0); // 조상인 Thread의 getName()을 호출
        }
    }
}
// 2. Runnable 인터페이스를 구현  Better!!! 이 방법이 보다 좋다고 함
class MyThread2 implements Runnable{
    @Override
    public void run() { // Runnable 인터페이스의 추상메서드 run()을 구현
        for(int i = 0; i < 500; i++){
            // Thread.currentThread() - 현재 실행중인 Thread를 반환한다.
            System.out.print(1);
        }
    }
}