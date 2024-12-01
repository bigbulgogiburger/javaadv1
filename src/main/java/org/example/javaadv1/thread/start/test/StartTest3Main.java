package org.example.javaadv1.thread.start.test;

import static org.example.javaadv1.thread.util.MyLogger.log;

public class StartTest3Main {
    public static void main(String[] args) {
        log(": start()");

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {for (int i = 0; i < 5; i++) {
                log("number : "+(i+1));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                    throw new RuntimeException(e);
                }

            }

            }
        }, "counter");

        thread.start();
        log(": start() end");
    }


    static class CounterThread implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                log("number : "+(i+1));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                    throw new RuntimeException(e);
                }

            }
        }
    }
}
