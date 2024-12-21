package org.example.javaadv1.thread.sync.test;

public class SyncTest1BadMain {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();


        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    counter.increment();
                }
            }
        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("counter.getCount() = " + counter.getCount());
    }
}
