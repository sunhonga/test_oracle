package com.shthread;

import com.utils.Time_Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName Interrupt
 * @Description TODO
 * Author sunhong
 * Date 2019-9-30 10:53
 **/
public class Interrupt {


    /**
     * 线程中断
     * interrupt()方法:给当前线程设置中断标志,但是并不中断线程.
     * interrupted()方法:返回线程的中断标志;并复原线程的中断标志(即为false).
     * isInterrupted()方法:只返回线程的中断状态，并不复原中断标志.
     */

    private static int i;

    public static void main(String[] args) {
        testWait();
       /* Thread thread = null;

        thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted())
                i++;
            System.out.println("Num:" + i);
        }, "interruptDemo");
        thread.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();*/
/*
        testSleep();
        testWait();*/
    }


    /**
     * 中断正在睡眠的线程
     * 测试sleep抛出InterruptedException...
     */
    public static void testSleep(){


        Thread thread1 = new Thread(()->{
            while (!Thread.currentThread().isInterrupted())
                i++;
            System.out.println("Num:" + i);
            try {
                Thread.sleep(900);          //使当前thread1线程睡眠。
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().isInterrupted());
                e.printStackTrace();
            }
        },"testSleep");
        thread1.start();
        thread1.interrupt();        //中断当前thread1线程，将中断标志为置为true，thread1线程会被UNpark唤醒，然后通过isInterrupted()判断当前线程是否被中断，如果中断则抛出InterruptedException异常,同时把中断标志为设置为false。

    }

    /**
     * 中断正在wait的线程，该线程目前放在同步队列里面
     */
    public static void testWait(){
        Object obj = new Object();
        Thread thread1 = new Thread(() -> {
            synchronized (obj) {
                while (!Thread.currentThread().isInterrupted())
                    i++;
                System.out.println("Num:" + i);
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().isInterrupted());
                    e.printStackTrace();
                }
            }
        }, "testWait");
        thread1.start();
        thread1.interrupt();        //中断当前thread1线程，将中断标志为置为true，thread1线程会被UNpark唤醒，然后通过isInterrupted()判断当前线程是否被中断，如果中断则抛出InterruptedException异常,同时把中断标志为设置为false。

    }
}
