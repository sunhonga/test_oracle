package com.shthread;

import java.sql.SQLOutput;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName TestCondition
 * @Description TODO
 * Author sunhong
 * Date 2020-4-12 21:04
 **/
public class TestCondition {


    public static void main(String[] args) {

        final Lock lock = new ReentrantLock();
        final Condition condition = lock.newCondition();

        new Thread(()->{
            lock.lock();
            System.out.println(Thread.currentThread().getName()+"拿到锁了");
            System.out.println(Thread.currentThread().getName()+"等待信号");
            try{
                condition.await();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"拿到信号");
            lock.unlock();

        },"Thread1").start();
        new Thread(()->{
            lock.lock();
            System.out.println(Thread.currentThread().getName()+"拿到锁了");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"发出信号");
            condition.signalAll();
            lock.unlock();
        },"线程2").start();

    }

}
