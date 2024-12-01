package org.example.javaadv1.thread.control;

public class CheckedExceptionMain {
    public static void main(String[] args) {

        CheckedRunnable runnable = new CheckedRunnable();

        Thread thread = new Thread(runnable);
        thread.start();
    }

    static class CheckedRunnable implements Runnable {

        @Override
        public void run() /*throw exception*/{
//            throw new RuntimeException();
        }
    }
}
