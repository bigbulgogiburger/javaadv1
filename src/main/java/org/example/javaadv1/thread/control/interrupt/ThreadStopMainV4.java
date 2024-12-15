package org.example.javaadv1.thread.control.interrupt;

import static org.example.javaadv1.thread.util.MyLogger.log;
import static org.example.javaadv1.thread.util.ThreadUtils.sleep;

public class ThreadStopMainV4 {

    public static void main(String[] args) {
        MyTask myTask = new MyTask();

        Thread thread = new Thread(myTask, "work");

        thread.start();

        sleep(100);
        log("작업 중단 지시 thread.interrupt");
        thread.interrupt();
        log("work 스레드 인터럽트 상태 1 = " + thread.isInterrupted());

    }


    static class MyTask implements Runnable {

        @Override
        public void run() {
            while (!Thread.interrupted()) { // 인터럽트 상태 변경x
                log("작업 중");
            }
            log("work interrupted 상태2 = " + Thread.currentThread().isInterrupted());

            try {
                log("자원 정리");

                Thread.sleep(1000);
                log("자원 종료");

            } catch (InterruptedException e) {
                log("자원정리 실패 - 정리 중 인터럽트 발생");
                log("work thread interrupted 상태 "+ Thread.currentThread().isInterrupted());
            }
        }
    }
}
