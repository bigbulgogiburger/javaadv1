package org.example.javaadv1.thread.executor.future;

import java.util.Random;
import java.util.concurrent.*;

import static org.example.javaadv1.thread.util.MyLogger.log;
import static org.example.javaadv1.thread.util.ThreadUtils.sleep;

public class CallableMainV2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(1);
        log("submit() 호출");
        Future<Integer> future = es.submit(new MyCallable());
        log("future 즉시 반환, future = "+ future);

        log("future.get() [블로킹] 메서드 호출 시작 -> main 스레드 waiting");
        Integer result = future.get();
        log("future.get() [블로킹] 메서드 호출 완료 -> main 스레드 runnable");
        log("result: " + result);
        log("future 완료, future = " +future);
        es.close();

    }

    static class MyCallable implements Callable<Integer> {

        @Override
        public Integer call() {
            log("Callable 시작");
            sleep(2000);
            int value = new Random().nextInt(10);
            log("Callable 완료");
            return value;
        }
    }
}
