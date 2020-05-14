package com.shthread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName SHExecutor
 * @Description TODO
 * Author sunhong
 * Date 2019-9-26 20:16
 **/
public class SHExecutor implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }

    static ExecutorService service = Executors.newFixedThreadPool(3);


    public static void main(String[] args) {


        for (int i = 0; i < 100; i++) {

            service.execute(()->{
                System.out.println("sdsadsa");
            });
        }
        service.shutdown();



    }
}
