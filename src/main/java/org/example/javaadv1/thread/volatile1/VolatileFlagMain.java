package org.example.javaadv1.thread.volatile1;

import static org.example.javaadv1.thread.util.MyLogger.log;
import static org.example.javaadv1.thread.util.ThreadUtils.sleep;

public class VolatileFlagMain {

    public static void main(String[] args) {
        MyTask myTask = new MyTask();
        Thread thread = new Thread(myTask,"work");
        log("run flag = "+myTask.runflag);
        thread.start();

        sleep(1000);
        log("run flag를 false로 변경 시도");
        myTask.runflag=false;
        log("runflag" + myTask.runflag);
        log("main 종료");
    }

    static class MyTask implements Runnable {

//        boolean runflag = true;
        volatile boolean runflag = true;
        @Override
        public void run() {
            log("태스크 시작");
            while (runflag){
                // runflag가 false로 변하면 탈출
            }
            log("태스크 종료");
        }
    }
}
