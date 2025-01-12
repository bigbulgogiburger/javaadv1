package org.example.javaadv1.thread.cas.increment;

import java.util.ArrayList;
import java.util.List;

import static org.example.javaadv1.thread.util.MyLogger.log;
import static org.example.javaadv1.thread.util.ThreadUtils.sleep;

public class IncrementThreadMain {

    public static final int THREAD_COUNT =1000;

    public static void main(String[] args) throws InterruptedException {
        test(new BasicInteger());
        test(new VolatileInteger());
        test(new SyncInteger());
        test(new MyAtomicInteger());
    }


    private static void test(IncrementInteger incrementInteger) throws InterruptedException {


        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                sleep(10); //너무 빨리 실행되기 때문에, 다른 스레드와 동시 실행을 위해 잠간 쉬었다가 실행
                incrementInteger.increment();
            }
        };

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            Thread thread = new Thread(runnable);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        int result = incrementInteger.get();

        System.out.println(incrementInteger.getClass().getSimpleName()+ " result: " + result);
    }
}
