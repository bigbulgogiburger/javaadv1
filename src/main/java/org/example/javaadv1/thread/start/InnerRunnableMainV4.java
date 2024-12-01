package org.example.javaadv1.thread.start;

import static org.example.javaadv1.thread.util.MyLogger.log;

public class InnerRunnableMainV4 {

    public static void main(String[] args) {
        log("main() start");

        Thread thread = new Thread(()-> log("run()")
        );

        thread.start();

        log("main() end");
    }

}
