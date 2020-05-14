package com.shthread;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName SHConcurrentHashMap
 * @Description TODO
 * Author sunhong
 * Date 2019-9-24 16:15
 **/
public class SHConcurrentHashMap {

    static  Map<String,String> chm = new ConcurrentHashMap<>();
    static Map<String ,String> map = new HashMap<>();
    static  int m =0;
    public static void main(String[] args) throws IOException {

        map.put("Aa","aaa");
        map.put("BB","bbb");

        map.put("BB1","bbb");
        map.put("BB2","bbb");
        map.put("BB3","bbb");
        map.put("BB4","bbb");
        map.put("BB5","bbb");
        map.put("BB6","bbb");
        map.put("BB7","bbb");
        map.put("BB8","bbb");
        map.put("BB9","bbb");
        map.put("BB10","bbb");
        map.put("BB11","bbb");
        map.put("BB12","bbb");
        map.put("BB13","bbb");
        map.put("BB14","bbb");


    }


}
