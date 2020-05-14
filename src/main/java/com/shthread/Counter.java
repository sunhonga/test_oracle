package com.shthread;

/**
 * @ClassName Counter
 * @Description TODO
 * Author sunhong
 * Date 2020-4-11 15:30\
 * �����Ƚϵ͵Ķ�-д����
 * ������ʹ��volatile��д����ʹ��synchronized
 **/
public class Counter {

    private volatile int value;


    public int getValue(){return  value;}

    public synchronized int increment(){
        return value++;
    }

}
