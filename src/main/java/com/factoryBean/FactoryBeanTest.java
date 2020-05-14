package com.factoryBean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName FactoryBeanTest
 * @Description TODO
 * Author sunhong
 * Date 2020-3-22 16:42
 **/
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class FactoryBeanTest {

    @Autowired
    ApplicationContext applicationContext;
    @Test
//    @Ignore
    public void test(){

        FactoryBeanService factoryBeanService = applicationContext.getBean(FactoryBeanService.class);
        factoryBeanService.testFactoryBean();
    }
}
