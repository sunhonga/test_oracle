package com.shthread;

import java.util.concurrent.*;

/**
 * @ClassName ThreadExtend_Pool_Return_Value
 * @Description TODO
 * Author sunhong
 * Date 2019-11-15 10:30
 * 带返回值的多线程使用
 **/
public class ThreadExtend_Pool_Return_Value {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Callable callable1 = new Callable() {
            @Override
            public Object call() throws Exception {
                return "我是callable1返回的值";
            }
        };

        Callable callable2 = new Callable() {
            @Override
            public Object call() throws Exception {
                return "我是callable2返回的值";
            }
        };

        Future future1 = executorService.submit(callable1);
        Future future2 = executorService.submit(callable2);

        System.out.println(future1.get().toString());
        System.out.println(future2.get().toString());

        executorService.shutdown();

    }





}
