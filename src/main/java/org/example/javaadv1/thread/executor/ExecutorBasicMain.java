package org.example.javaadv1.thread.executor;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static org.example.javaadv1.thread.executor.ExecutorUtils.*;
import static org.example.javaadv1.thread.util.MyLogger.log;
import static org.example.javaadv1.thread.util.ThreadUtils.sleep;

public class ExecutorBasicMain {

    public static void main(String[] args) {
        ThreadPoolExecutor es = new ThreadPoolExecutor(2, 2, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        log("== 초기 상태 == ");
        printState(es);

        es.execute(new RunnableTask("taskA"));
        es.execute(new RunnableTask("taskB"));
        es.execute(new RunnableTask("taskC"));
        es.execute(new RunnableTask("taskD"));
        log("작업 수행 중");
        printState(es);

        sleep(3000);
        log("== 작업 수행 완료 == ");
        printState(es);

        es.close();
        log("== shutdown 완료 ==");
        printState(es);
    }
}
