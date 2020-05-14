package com.shthread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName SHHash
 * @Description TODO
 * Author sunhong
 * Date 2019-9-25 13:24
 **/
public class SHHash {

    public static void main(String[] args) throws InterruptedException {

        Map<String,String> map = new ConcurrentHashMap<>();
        map.put("sss","sad");
        Thread.currentThread().wait();
    }
}
