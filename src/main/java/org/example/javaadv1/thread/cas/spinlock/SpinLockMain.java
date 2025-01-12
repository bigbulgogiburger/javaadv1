package org.example.javaadv1.thread.cas.spinlock;

import static org.example.javaadv1.thread.util.MyLogger.log;
import static org.example.javaadv1.thread.util.ThreadUtils.sleep;

public class SpinLockMain {

    public static void main(String[] args) {
        SpinLockBad spinLockBad = new SpinLockBad();
        SpinLock spinLock = new SpinLock();

        Runnable task = new Runnable() {
            @Override
            public void run() {
                spinLock.lock();

                try {
                    //critical section
                    log("비즈니스 로직 실행");
                    sleep(10); // 오래걸리는 로직에서 스핀락 사용 x
                } finally {
                    spinLock.unlock();
                }
            }
        };

        Thread thread1 = new Thread(task, "Thread-1");
        Thread thread2 = new Thread(task, "Thread-2");

        thread1.start();
        thread2.start();

    }
}
