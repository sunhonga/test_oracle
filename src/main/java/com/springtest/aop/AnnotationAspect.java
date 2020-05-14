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
 * 在使用spring框架配置AOP的时候，不管是通过XML配置文件还是注解的方式都需要定义pointcut"切入点"
 *
 * 例如定义切入点表达式 execution(* com.sample.service.impl..*.*(..))
 *
 * execution()是最常用的切点函数，其语法如下所示：
 *
 *  整个表达式可以分为五个部分：
 *
 *  1、execution(): 表达式主体。
 *
 *  2、第一个*号：表示返回类型，*号表示所有的类型。
 *
 *  3、包名：表示需要拦截的包名，后面的两个句点表示当前包和当前包的所有子包，com.sample.service.impl包、子孙包下所有类的方法。
 *
 *  4、第二个*号：表示类名，*号表示所有的类。
 *
 *  5、*(..):最后这个星号表示方法名，*号表示所有的方法，后面括弧里面表示方法的参数，两个句点表示任何参数。
 **/


@Component
@Aspect
public class AnnotationAspect {

//    private final static Logger log = Logger.getLogger(AnnotationAspect.class);
    //配置切入点，该方法无方法体，主要为方便同类中其他方法使用此处配置的切入点
    @Pointcut("execution(* com.springtest..*.save(..))")
    public void aspect(){}

    @Before("aspect()")
    public void before(JoinPoint joinPoint){
        System.out.println("before通知" +joinPoint);
    }

    @Around("aspect()")
    public void around(JoinPoint joinPoint){
        long start = System.currentTimeMillis();
        try{
            ((ProceedingJoinPoint) joinPoint).proceed();
            long end = System.currentTimeMillis();
            System.out.println("around通知" + joinPoint + "\tUse time " +(end-start) + " ms!");
        }catch (Throwable e){
            long end  = System.currentTimeMillis();
            System.out.println("around通知" + joinPoint + "\tUse time " +(end-start) + " ms with execption :" + e.getMessage());
        }
    }

    @AfterReturning("aspect()")
    public void afterReturn(JoinPoint joinPoint){
        System.out.println("afterReturn通知 " + joinPoint);
    }

    @AfterThrowing(pointcut = "aspect()",throwing = "ex")
    public void afterThrow(JoinPoint joinPoint,Exception ex){
        System.out.println("afterThrow通知" + joinPoint + "\t"+ex.getMessage());
    }


}
