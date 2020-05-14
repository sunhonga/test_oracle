package com.shthread;

/**
 * @ClassName LazySingleton
 * @Description TODO
 * Author sunhong
 * Date 2020-4-11 15:22
 * 双重检查单例模式发布对象
 **/
public class LazySingleton {

    private static volatile  LazySingleton lazySingleton;

    private LazySingleton(){

    }

    public static LazySingleton getInstance(){
        if(lazySingleton == null){
            synchronized (LazySingleton.class){
                if (lazySingleton == null){
                    lazySingleton = new LazySingleton();
                    //分成三部执行：
                    //1.分配内存给这个对象;
                    //2.初始化对象
                    //3.将初始化好的对象和内存地址建立关系,赋值。
                }
            }
        }


        return lazySingleton;
    }



}
