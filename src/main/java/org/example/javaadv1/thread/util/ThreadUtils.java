package org.example.javaadv1.thread.util;

import static org.example.javaadv1.thread.util.MyLogger.log;

public abstract class ThreadUtils {

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            log("인터럽트발생"+e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
