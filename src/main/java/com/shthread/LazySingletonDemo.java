package com.shthread;

/**
 * @ClassName LazySingletonDemo
 * @Description TODO
 * Author sunhong
 * Date 2020-4-16 19:27
 **/
public class LazySingletonDemo implements Runnable {



    @Override
    public void run() {
        System.out.println(LazySingleton.getInstance());
    }

    public static void main(String[] args) {

        for (int i = 0; i < 2; i++) {
            new Thread(new LazySingletonDemo()::run).start();
        }
    }
}
