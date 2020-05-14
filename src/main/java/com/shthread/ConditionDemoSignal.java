package com.shthread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @ClassName ConditionDemoSignal
 * @Description TODO
 * Author sunhong
 * Date 2020-4-12 14:23
 **/
public class ConditionDemoSignal implements Runnable {

    private Lock lock;
    private Condition condition;

    public ConditionDemoSignal(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        System.out.println("begin-ConditionDemoSignal");
        try{
            lock.lock();
            condition.signal();
            System.out.println("end-ConditionDemoSignal");
        }finally {
            lock.unlock();
        }
    }
}
