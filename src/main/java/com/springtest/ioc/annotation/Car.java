package com.springtest.ioc.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @ClassName Car
 * @Description TODO
 * Author sunhong
 * Date 2020-3-29 14:16
 **/
@Component
public class Car {

    @Autowired
    private  Color color;

    @Resource
    private ITire tire;

    private String name;


    public void say(){
        System.out.println("Œ“ «"+this.name+"≥µ");
        color.say();
        tire.say();
    }

}
