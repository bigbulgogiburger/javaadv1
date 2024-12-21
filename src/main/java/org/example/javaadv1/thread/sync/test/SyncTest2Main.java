package org.example.javaadv1.thread.sync.test;

import static org.example.javaadv1.thread.util.MyLogger.log;

public class SyncTest2Main {

    public static void main(String[] args) throws InterruptedException {
        MyCounter myCounter = new MyCounter();

        Runnable task = myCounter::count;


        Thread thread1 = new Thread(task, "thread1");
        Thread thread2 = new Thread(task, "thread2");

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();


    }


    static class MyCounter{


        public void count() {
            int localValue =0;
            for (int i = 0; i < 1000; i++) {
                localValue = localValue+1;
            }
            log("결과 : " +localValue);

        }
    }
}
