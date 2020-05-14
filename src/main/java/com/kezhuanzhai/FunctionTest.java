package com.kezhuanzhai;

/**
 * @ClassName FunctionTest
 * @Description TODO
 * Author sunhong
 * Date 2020-3-22 15:55
 **/
public class FunctionTest {


    public static void main(String[] args) {

        say("Ëïºé",()->{
           return getAge();
        });

    }




    public static  void say(String name,SunFunction<?> sunFunction){
        System.out.println("sssss");
        sunFunction.getObject();

    }


    public static String getAge(){
        return "25";
    }

    public static  void say2(String s1,Object o){


        System.out.println("qwre");
    }
}
