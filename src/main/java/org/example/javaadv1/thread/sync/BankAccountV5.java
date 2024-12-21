package org.example.javaadv1.thread.sync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static org.example.javaadv1.thread.util.MyLogger.log;
import static org.example.javaadv1.thread.util.ThreadUtils.sleep;

public class BankAccountV5 implements BankAccount {

    private int balance;

    private final Lock lock = new ReentrantLock();

    public BankAccountV5(int initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public boolean withdraw(int amount) {
        log("거래 시작 : " + getClass().getSimpleName());

        if(!lock.tryLock()) {

            log("[진입 실패] 이미 처리중인 작업이 있습니다.");
            return false;
        }

//        lock.lock(); // reentrantLock 이용하여 lock을 걸기

        try{
            log("[검증 시작] 출금액: " + amount + ",잔액 : " + balance);

            if (balance < amount) {
                log("[검증 실패] 출금액: " + amount + ",잔액 : " + balance);
                return false;
            }

            log("[검증 완료] 출금액: " + amount + ",잔액 : " + balance);
            sleep(1000); // 출금에 걸리는 시간으로 가정
            balance -= amount;
            log("[검증 완료] 출금액: " + amount + ",잔액 : " + balance);

        }finally { // 반드시 try-finally unlock
            lock.unlock();
        }


        log("거래 종료");
        return true;
    }

    @Override
    public int getBalance() {
        lock.lock();  // reentrantLock 이용하여 lock을 걸기
        try {
            return balance;
        }finally {
            lock.unlock();
        }
    }
}