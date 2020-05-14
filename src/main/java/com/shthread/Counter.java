package com.shthread;

/**
 * @ClassName Counter
 * @Description TODO
 * Author sunhong
 * Date 2020-4-11 15:30\
 * 开销比较低的读-写策略
 * 读操作使用volatile，写操作使用synchronized
 **/
public class Counter {

    private volatile int value;


    public int getValue(){return  value;}

    public synchronized int increment(){
        return value++;
    }

}
