package com.springtest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


/**
 * @ClassName AnnotationAspect
 * @Description TODO
 * Author sunhong
 * Date 2020-3-18 11:36
 * ��ʹ��spring�������AOP��ʱ�򣬲�����ͨ��XML�����ļ�����ע��ķ�ʽ����Ҫ����pointcut"�����"
 *
 * ���綨���������ʽ execution(* com.sample.service.impl..*.*(..))
 *
 * execution()����õ��е㺯�������﷨������ʾ��
 *
 *  �������ʽ���Է�Ϊ������֣�
 *
 *  1��execution(): ���ʽ���塣
 *
 *  2����һ��*�ţ���ʾ�������ͣ�*�ű�ʾ���е����͡�
 *
 *  3����������ʾ��Ҫ���صİ������������������ʾ��ǰ���͵�ǰ���������Ӱ���com.sample.service.impl�����������������ķ�����
 *
 *  4���ڶ���*�ţ���ʾ������*�ű�ʾ���е��ࡣ
 *
 *  5��*(..):�������Ǻű�ʾ��������*�ű�ʾ���еķ������������������ʾ�����Ĳ�������������ʾ�κβ�����
 **/


@Component
@Aspect
public class AnnotationAspect {

//    private final static Logger log = Logger.getLogger(AnnotationAspect.class);
    //��������㣬�÷����޷����壬��ҪΪ����ͬ������������ʹ�ô˴����õ������
    @Pointcut("execution(* com.springtest..*.save(..))")
    public void aspect(){}

    @Before("aspect()")
    public void before(JoinPoint joinPoint){
        System.out.println("before֪ͨ" +joinPoint);
    }

    @Around("aspect()")
    public void around(JoinPoint joinPoint){
        long start = System.currentTimeMillis();
        try{
            ((ProceedingJoinPoint) joinPoint).proceed();
            long end = System.currentTimeMillis();
            System.out.println("around֪ͨ" + joinPoint + "\tUse time " +(end-start) + " ms!");
        }catch (Throwable e){
            long end  = System.currentTimeMillis();
            System.out.println("around֪ͨ" + joinPoint + "\tUse time " +(end-start) + " ms with execption :" + e.getMessage());
        }
    }

    @AfterReturning("aspect()")
    public void afterReturn(JoinPoint joinPoint){
        System.out.println("afterReturn֪ͨ " + joinPoint);
    }

    @AfterThrowing(pointcut = "aspect()",throwing = "ex")
    public void afterThrow(JoinPoint joinPoint,Exception ex){
        System.out.println("afterThrow֪ͨ" + joinPoint + "\t"+ex.getMessage());
    }


}
