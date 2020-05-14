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
     * �߳��ж�
     * interrupt()����:����ǰ�߳������жϱ�־,���ǲ����ж��߳�.
     * interrupted()����:�����̵߳��жϱ�־;����ԭ�̵߳��жϱ�־(��Ϊfalse).
     * isInterrupted()����:ֻ�����̵߳��ж�״̬��������ԭ�жϱ�־.
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
     * �ж�����˯�ߵ��߳�
     * ����sleep�׳�InterruptedException...
     */
    public static void testSleep(){


        Thread thread1 = new Thread(()->{
            while (!Thread.currentThread().isInterrupted())
                i++;
            System.out.println("Num:" + i);
            try {
                Thread.sleep(900);          //ʹ��ǰthread1�߳�˯�ߡ�
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().isInterrupted());
                e.printStackTrace();
            }
        },"testSleep");
        thread1.start();
        thread1.interrupt();        //�жϵ�ǰthread1�̣߳����жϱ�־Ϊ��Ϊtrue��thread1�̻߳ᱻUNpark���ѣ�Ȼ��ͨ��isInterrupted()�жϵ�ǰ�߳��Ƿ��жϣ�����ж����׳�InterruptedException�쳣,ͬʱ���жϱ�־Ϊ����Ϊfalse��

    }

    /**
     * �ж�����wait���̣߳����߳�Ŀǰ����ͬ����������
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
        thread1.interrupt();        //�жϵ�ǰthread1�̣߳����жϱ�־Ϊ��Ϊtrue��thread1�̻߳ᱻUNpark���ѣ�Ȼ��ͨ��isInterrupted()�жϵ�ǰ�߳��Ƿ��жϣ�����ж����׳�InterruptedException�쳣,ͬʱ���жϱ�־Ϊ����Ϊfalse��

    }
}
