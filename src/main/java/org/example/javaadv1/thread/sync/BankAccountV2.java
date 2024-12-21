package org.example.javaadv1.thread.sync;

import static org.example.javaadv1.thread.util.MyLogger.log;
import static org.example.javaadv1.thread.util.ThreadUtils.sleep;

public class BankAccountV2 implements BankAccount{

    private int balance;

    public BankAccountV2(int initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public synchronized boolean withdraw(int amount) {
        log("거래 시작 : " + getClass().getSimpleName());



        // == 임계 영역 시작 ==
        log("[검증 시작] 출금액: " + amount+",잔액 : " + balance);

        if(balance<amount){
            log("[검증 실패] 출금액: " + amount+",잔액 : " + balance);
            return false;
        }

        log("[검증 완료] 출금액: " + amount+",잔액 : " + balance);
        sleep(1000); // 출금에 걸리는 시간으로 가정
        balance-=amount;
        log("[검증 완료] 출금액: " + amount+",잔액 : " + balance);

        //== 임계 영역 종료

        log("거래 종료");
        return true;
    }

    @Override
    public synchronized int getBalance() {
        return balance;
    }
}