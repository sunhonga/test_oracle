package com.shthread;

import org.omg.PortableServer.THREAD_POLICY_ID;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName ThreadPoolDemo
 * @Description TODO
 * Author sunhong
 * Date 2020-4-14 20:28
 **/
public class ThreadPoolDemo implements Runnable
{
    @Override
    public void run() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }


    static ExecutorService service = Executors.newFixedThreadPool(3);


    static ExecutorService service2 =
            new ThreadPoolExecutor(1,1,1, TimeUnit.MILLISECONDS,null,null,null);

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            service.execute(new ThreadPoolDemo());
        }
        service.shutdown();
    }
}
