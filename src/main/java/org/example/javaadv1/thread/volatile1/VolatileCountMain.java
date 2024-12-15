package org.example.javaadv1.thread.volatile1;

import static org.example.javaadv1.thread.util.MyLogger.log;
import static org.example.javaadv1.thread.util.ThreadUtils.sleep;

public class VolatileCountMain {

    public static void main(String[] args) {
        MyTask myTask = new MyTask();
        Thread thread = new Thread(myTask,"work");
        thread.start();
        sleep(1000);
        log("run flag를 false로 변경 시도");
        myTask.runFlag =false;
        log("flag =" + myTask.runFlag +", count = "+myTask.count+ " in main()");
        log("main 종료");
    }

    static class MyTask implements Runnable {

//        boolean runFlag = true;
//        long count;
        volatile boolean runFlag = true;
         volatile long count;
        @Override
        public void run() {
            log("태스크 시작");
            while (runFlag){
                count++;

                if(count % 100_000_000 == 0){
                    log("flag =" + runFlag +", count = "+count+ " in while()");
                }
                // runflag가 false로 변하면 탈출
            }
            log("flag =" + runFlag +", count = "+count+ "종료");
        }
    }
}
