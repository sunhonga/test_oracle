package com.springtest.ioc.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName TesAnnotationIoc
 * @Description TODO
 * Author sunhong
 * Date 2020-3-29 14:20
 **/
public class TesAnnotationIoc {


    public static void main(String[] args) {


        ApplicationContext ac = new AnnotationConfigApplicationContext("com.springtest.ioc.annotation");
        Car car = (Car) ac.getBean("car");
        car.say();
    }
}
