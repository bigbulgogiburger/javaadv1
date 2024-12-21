package org.example.javaadv1.thread.sync.lock;

import java.util.concurrent.locks.LockSupport;

import static org.example.javaadv1.thread.util.MyLogger.log;
import static org.example.javaadv1.thread.util.ThreadUtils.sleep;

public class LockSupportMainV2 {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new PartTest(), "Thread-1");
        thread1.start();

        // 잠시 대기하여 thread-1 park state에 빠질 시간을 준다.
        sleep(100);
        log("thread -1 state ; " + thread1.getState());
        log("main -> unpark(Thread-1)");
//        LockSupport.unpark(thread1); // 1. unpark 사용 interrupt 상태 false
//        thread1.interrupt();// 2. interrupt 사용 interrupt 상태 true
    }

    static class PartTest implements Runnable {
        @Override
        public void run() {
            log("park 시작");
            LockSupport.parkNanos(2000_000_000);
            log("park 종료 ,state: "+ Thread.currentThread().getState());
            log("인터럽트 상태: " + Thread.currentThread().isInterrupted());
        }
    }
}
