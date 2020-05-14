package com.springtest.ioc.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName Son
 * @Description TODO
 * Author sunhong
 * Date 2020-3-7 11:30
 **/
public class Son extends Father {


    public void say(){
        System.out.println("son 说话");
    }


    public static void main(String[] args) {
        //xml文件加载bean
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext-ioc.xml");
        applicationContext.getBean("hobby");
        //注解方式加载bean
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        Son s = new Son();
        s.peak();
    }


}
