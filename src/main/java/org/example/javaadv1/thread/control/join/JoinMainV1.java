package org.example.javaadv1.thread.control.join;

import static org.example.javaadv1.thread.util.MyLogger.log;
import static org.example.javaadv1.thread.util.ThreadUtils.sleep;

public class JoinMainV1 {

    public static void main(String[] args) {
        log("Start");
        SumTask task1 = new SumTask(1, 50);
        SumTask task2 = new SumTask(51, 100);
        Thread thread1 = new Thread(task1, "thread-1");
        Thread thread2 = new Thread(task2, "thread-2");

        thread1.start();
        thread2.start();

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
