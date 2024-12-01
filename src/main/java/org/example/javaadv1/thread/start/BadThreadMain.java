package org.example.javaadv1.thread.start;

public class BadThreadMain {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " : main() start");


        HelloThread helloThread = new HelloThread();
        System.out.println(Thread.currentThread().getName() + " : start() 호출 전");

        // run 직접실행하면 main Thread가 실행해버림.
        helloThread.run();
        ;
        System.out.println(Thread.currentThread().getName() + " : start() 호출 후");

        System.out.println(Thread.currentThread().getName() + " : main() end");
    }
}
