package com.demo;

/**
 * @ClassName MyExtensionLoader
 * @Description TODO
 * Author sunhong
 * Date 2019-9-6 14:00
 **/
public class MyExtensionLoader<T> {


    private final Class<?> type;

    public MyExtensionLoader(Class<?> type) {
        this.type = type;
        System.out.println("sss");
    }

    public static <T> void say(Class<T> type){
        System.out.println("123");
    }
}
