package org.example.javaadv1.thread.control.printer;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

import static org.example.javaadv1.thread.util.MyLogger.log;

public class MyPrinterV3 {

    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread thread = new Thread(printer, "printer");

        thread.start();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            log("프린터 할 문서를 입력하세요. 종료 (q) :");
            String input = scanner.nextLine();
            if (input.equals("q")) {
                thread.interrupt();
                break;
            }
            printer.addJob(input);
        }

    }

    static class Printer implements Runnable {
        volatile boolean work = true;
        Queue<String> jobQueue = new ConcurrentLinkedQueue<>();

        @Override
        public void run() {
            while (!Thread.interrupted()) {
                if (jobQueue.isEmpty()) {
                    continue;
                }

                String job = jobQueue.poll();

                try {
                    log("출력 시작 " + job + ", 대기문서" + jobQueue);
                    Thread.sleep(3000);
                    log("출력완료");

                } catch (InterruptedException e) {
                    log("인터럽트!");
                    break;
                }
            }

            log("프린터 종료");
        }

        public void addJob(String job) {
            this.jobQueue.offer(job);
        }
    }
}
