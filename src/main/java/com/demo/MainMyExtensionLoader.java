package com.demo;

/**
 * @ClassName MainMyExtensionLoader
 * @Description TODO
 * Author sunhong
 * Date 2019-9-6 14:03
 **/
public class MainMyExtensionLoader {

    public static void main(String[] args) {

        MyExtensionLoader.say(MainMyExtensionLoader.class);
        Class<?> type = IPersonImpl.class;
        if ( type == IPerson.class){
            System.out.println("true");
        }

        
    }
}
