package com.shthread;

/**
 * @ClassName VolatileDemo
 * @Description TODO
 * Author sunhong
 * Date 2020-4-9 20:26
 **/
public class VolatileDemo {

    /**
     * volatile����ʹ���ڶദ���������±�֤�����ÿɼ���
     */
    public volatile static boolean stop = false;

    public static void main(String[] args) throws InterruptedException {

        Thread thread  = new Thread(()->{
            int i =0;
            while (!stop){
                i++;
            }
        });

        thread.start();
        System.out.println("begin start thread");
        Thread.sleep(1000);
        stop = true;
    }

}
