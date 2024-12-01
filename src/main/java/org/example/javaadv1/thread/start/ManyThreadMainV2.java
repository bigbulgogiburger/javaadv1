package org.example.javaadv1.thread.start;

import static org.example.javaadv1.thread.util.MyLogger.log;

public class ManyThreadMainV2 {
    public static void main(String[] args) {
        log("main() start");

        HelloRunnable helloRunnable = new HelloRunnable();

        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(helloRunnable);
            thread.start();

        }

        Thread thread1 = new Thread(helloRunnable);
        thread1.start();
        Thread thread2 = new Thread(helloRunnable);
        thread2.start();
        Thread thread3 = new Thread(helloRunnable);
        thread3.start();

        log("main() end");
    }
}
