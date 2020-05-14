package com.factoryBean;

import org.springframework.stereotype.Component;

/**
 * @ClassName FactoryBeanServiceImpl
 * @Description TODO
 * Author sunhong
 * Date 2020-3-22 16:47
 **/

public class FactoryBeanServiceImpl implements FactoryBeanService {
    @Override
    public void testFactoryBean() {
        System.out.println("我是FactoryBean的一个测试类");
    }
}
