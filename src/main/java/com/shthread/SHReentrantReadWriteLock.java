package com.shthread;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @ClassName SHReentrantReadWriteLock
 * @Description TODO
 * Author sunhong
 * Date 2019-9-18 13:17
 **/
public class SHReentrantReadWriteLock {


    static Map<Integer, Integer> cacheMap = new HashMap<Integer, Integer>();
    static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    static Lock read = rwl.readLock();
    static Lock write = rwl.writeLock();


    public static final Object get(String key){
        System.out.println("开始读取数据");
        read.lock();
        try{
            return cacheMap.get(key);
        }finally {
            read.unlock();
        }
    }

    public static final Object put(Integer key, Integer value){
        write.lock();
        System.out.println("开始写数据");
        try{
            return cacheMap.put(key,value);
        }finally {
            write.unlock();
        }
    }

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            new Thread(() ->{
                if(finalI % 3 == 0){
                    cacheMap.put(finalI,finalI*3);
                }else {
                    cacheMap.put(finalI,finalI);
                }
            }).start();
        }

       System.in.read();
    }



}
