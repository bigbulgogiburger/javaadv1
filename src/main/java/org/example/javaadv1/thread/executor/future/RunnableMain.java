package org.example.javaadv1.thread.executor.future;

import java.util.Random;

import static org.example.javaadv1.thread.util.MyLogger.log;
import static org.example.javaadv1.thread.util.ThreadUtils.sleep;

public class RunnableMain {

    public static void main(String[] args) throws InterruptedException {
        MyRunnable task = new MyRunnable();
        Thread thread = new Thread(task, "Thread-1");
        thread.start();
        thread.join();
        int value = task.value;
        System.out.println("value = " + value);
    }

    static class MyRunnable implements Runnable {
        int value;

        @Override
        public void run() {
            log("Runnable start");
            sleep(2000);
            value = new Random().nextInt(10);
            log("create value = "+value);
            log("runnable 완료");

        }
    }
}
