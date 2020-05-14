package com.springtest.ioc.annotation;

import org.springframework.stereotype.Component;

/**
 * @ClassName TireService
 * @Description TODO
 * Author sunhong
 * Date 2020-3-30 16:32
 **/
@Component
public class TireService implements ITire {

    public void say(){
        System.out.println("说出自己的轮胎：TireService");
    }

}
