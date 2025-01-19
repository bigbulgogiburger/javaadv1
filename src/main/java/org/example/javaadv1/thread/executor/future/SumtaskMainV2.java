package org.example.javaadv1.thread.executor.future;

import java.util.concurrent.*;

import static org.example.javaadv1.thread.util.MyLogger.log;
import static org.example.javaadv1.thread.util.ThreadUtils.sleep;

public class SumtaskMainV2
{
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Sumtask task1 = new Sumtask(1, 50);
        Sumtask task2 = new Sumtask(51, 100);

        ExecutorService es = Executors.newFixedThreadPool(2);

        Future<Integer> future1 = es.submit(task1);
        Future<Integer> future2 = es.submit(task2);


        Integer sum1 = future1.get();
        Integer sum2 = future2.get();

        log("task1.result1 = " +sum1);
        log("task1.result2 = " +sum2);

        int sumAll = sum1 + sum2;

        log("task1 + task2 = " +sumAll);
        log("end");

        es.close();

    }

    static class Sumtask implements Callable<Integer>{

        int startValue;
        int endValue;

        public Sumtask(int startValue, int endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        public Integer call() throws InterruptedException {
            log("작업 시작");
            Thread.sleep(2000);
            int sum = 0;
            for (int i = startValue; i <= endValue; i++) {
                sum += i;
            }

            log("작업완료 result = " + sum);
            return sum;
        }
    }
}
