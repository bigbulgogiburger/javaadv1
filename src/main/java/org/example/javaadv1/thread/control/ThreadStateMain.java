package org.example.javaadv1.thread.control;

import static org.example.javaadv1.thread.util.MyLogger.log;

public class ThreadStateMain {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyRunnable(), "myThread");
        log("myThread.state1 = " + thread.getState()); //new
        log("mythread.start()");
        thread.start();
        Thread.sleep(1000);
        log("myThread.state3 = " + thread.getState()); // timed waiting
        Thread.sleep(3500);
        log("myThread.state5 = " + thread.getState()); // terminated

        log("end");


    }


    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            try {

                log("start");
                log("myThread.state2 = " + Thread.currentThread().getState()); //runnable
                log("sleep() start");
                Thread.sleep(3000);
                log("sleep() end");
                log("myThread.state4 = " + Thread.currentThread().getState()); //runnable


            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
