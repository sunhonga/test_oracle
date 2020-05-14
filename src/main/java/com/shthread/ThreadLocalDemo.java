package com.shthread;

/**
 * @ClassName ThreadLocalDemo
 * @Description TODO
 * Author sunhong
 * Date 2020-4-14 9:02
 **/
public class ThreadLocalDemo {

    static ThreadLocal<Integer> threadLocal = new ThreadLocal(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };


    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(()->{
                int a = threadLocal.get();
                a = a+5;
                threadLocal.set(a);
                System.out.println(Thread.currentThread().getName()+threadLocal.get());
            },"Thread"+i);
        }
        Thread.sleep(1000);
        for (Thread thread : threads) {
            thread.start();
        }


    }

}