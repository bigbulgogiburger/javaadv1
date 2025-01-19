package org.example.javaadv1.thread.executor.future;

import org.example.javaadv1.thread.control.join.JoinMainV1;
import org.example.javaadv1.thread.control.join.JoinMainV4;

import static org.example.javaadv1.thread.util.MyLogger.log;
import static org.example.javaadv1.thread.util.ThreadUtils.sleep;

public class SumTaskMainV1 {

    public static void main(String[] args) throws InterruptedException {
        log("Start");
        SumTask task1 = new SumTask(1, 50);
        SumTask task2 = new SumTask(51, 100);
        Thread thread1 = new Thread(task1, "thread-1");
        Thread thread2 = new Thread(task2, "thread-2");

        thread1.start();
        thread2.start();

        log("join(1000) - main thread thread1가 종료까지 1초 대기");
        // 스레드가 종료될 때 까지 대기
        thread1.join(1000);
        thread2.join();


        int sumAll= task1.result + task2.result;
        log("sumAll: " + sumAll);

        log("end");
    }


    static class SumTask implements Runnable {

        int startValue;
        int endValue;
        int result;

        public SumTask(int startValue, int endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        public void run() {
            log("작업시작");
            sleep(1000);
            int sum = 0;

            for (int i = startValue; i <= endValue; i++) {
                sum += i;
            }

            result = sum;
            log("작업완료 result: " + result);
        }
    }
}
