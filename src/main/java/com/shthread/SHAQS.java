package com.shthread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName SHAQS
 * @Description TODO
 * Author sunhong
 * Date 2019-9-17 14:22
 **/
public class SHAQS {


    public static int a = 0;
    public static Lock lock = new ReentrantLock();

    public static void inc(){
        lock.lock();
        a++;
        lock.unlock();
    }


    public static void main(String[] args) {

        for (int i = 0; i < 1000; i++) {
            new Thread(SHAQS::inc).start();
        }
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(a);
    }

}
