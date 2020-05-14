package com.springtest.ioc.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName Color
 * @Description TODO
 * Author sunhong
 * Date 2020-3-29 14:16
 **/
@Component
public class Color {


    @Autowired
    private Red red;

    public void say(){
        System.out.println("说出自己的颜色");
    }
}
