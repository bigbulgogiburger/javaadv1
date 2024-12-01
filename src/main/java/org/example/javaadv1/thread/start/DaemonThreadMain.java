package org.example.javaadv1.thread.start;

public class DaemonThreadMain {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " : main() start");
        DaemonThread daemonThread = new DaemonThread();
        daemonThread.setDaemon(true);
        daemonThread.start();

        System.out.println(Thread.currentThread().getName() + " : main() end");
    }

    static class DaemonThread extends Thread {
        // thread method는 checked 예외를 던질 수 없고, 잡을 수만 있음.
        // runtimeError는 상관없음.
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " : run()");
            try {
                Thread.sleep(10000); //10초간 실행
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            // daemon은 사용자 쓰레드가 끝나면 종료가 되어서, 이 출력문이 나오기 전에 종료됨.
            System.out.println(Thread.currentThread().getName() + " : run() end");
        }
    }
}
