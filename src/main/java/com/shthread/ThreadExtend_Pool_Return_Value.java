package com.shthread;

import java.util.concurrent.*;

/**
 * @ClassName ThreadExtend_Pool_Return_Value
 * @Description TODO
 * Author sunhong
 * Date 2019-11-15 10:30
 * ������ֵ�Ķ��߳�ʹ��
 **/
public class ThreadExtend_Pool_Return_Value {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Callable callable1 = new Callable() {
            @Override
            public Object call() throws Exception {
                return "����callable1���ص�ֵ";
            }
        };

        Callable callable2 = new Callable() {
            @Override
            public Object call() throws Exception {
                return "����callable2���ص�ֵ";
            }
        };

        Future future1 = executorService.submit(callable1);
        Future future2 = executorService.submit(callable2);

        System.out.println(future1.get().toString());
        System.out.println(future2.get().toString());

        executorService.shutdown();

    }





}
