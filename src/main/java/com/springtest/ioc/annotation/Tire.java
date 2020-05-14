package com.springtest.ioc.annotation;

import org.springframework.stereotype.Component;

/**
 * @ClassName Tire
 * @Description TODO
 * Author sunhong
 * Date 2020-3-29 17:29
 **/
@Component
public class Tire implements ITire{


    public void say(){
        System.out.println("说出自己的轮胎");
    }
}
