package org.example.javaadv1.thread.start.test;

import static org.example.javaadv1.thread.util.MyLogger.log;

public class StartTest4Main {
    public static void main(String[] args) {
        log(": start()");

        Thread threadA = new Thread(new PrintRunnable("A",1000), "Thread-A");
        Thread threadB = new Thread(new PrintRunnable("B",500), "Thread-B");
        threadA.start();
        threadB.start();
        log(": start() end");
    }


    static class PrintRunnable implements Runnable {

        private final String content;
        private final int sleepMs;


        public PrintRunnable(String content, int sleepMs) {
            this.content = content;
            this.sleepMs = sleepMs;
        }

        @Override
        public void run() {
            while (true)
            {
                log(content);
                try {
                    Thread.sleep(sleepMs);
                } catch (InterruptedException e) {

                    throw new RuntimeException(e);
                }

            }
        }
    }
}
