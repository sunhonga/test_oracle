package com.springtest.aop;

import com.springtest.test.Test1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName AopTest
 * @Description TODO
 * Author sunhong
 * Date 2020-3-18 11:33
 **/
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class AopTest {

//    private final static Logger log = Logger.getLogger(AopTest.class);

    @Autowired
    private ImemberService memberService;


    @Autowired
    private ApplicationContext applicationContext;


    @Autowired
    private Test1 test1;
    @Test
    public void test(){
        System.out.println("==================这是一条华丽的分割线");
        memberService.save();
        //test1.save1();
        System.out.println("==================这是一条华丽的分割线");

    }

}
