package com.shthread;

/**
 * @ClassName SynDemo
 * @Description TODO
 * Author sunhong
 * Date 2020-4-11 15:56
 **/
public class SynDemo {


    private static  int count = 0;
    public  static void inc(){
        synchronized (SynDemo.class){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;}
    }

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 1000; i++) {
            new  Thread(()->SynDemo.inc()).start();
        }
        Thread.sleep(3000);

        System.out.println(count);

    }

}
