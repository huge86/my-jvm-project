package cn.huzunjie.spring5.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @Author HuZunJie
 * @Date 2021/2/5 19:55
 * @Email 826992656@qq.com
 * @Version 1.0
 */

public class AopByAnnotation {
    //
    //
    @Test
    public void testBeforeAop(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("aop.xml");
        GeneralUser generalUser = ctx.getBean("generalUser", GeneralUser.class);
        generalUser.add();

    }

}


//1、创建普通类，cn.huzunjie.spring5.beans.User在类里面定义方法
@Component
 class GeneralUser {
    private String userName;
    public void add(){
        System.out.println("add方法，输出");
    }
}

//2、创建增强类，创建方法，让不同的方法代表不同类型的通知
@Component
@Aspect
class EnhancedUser {
    //前置通知：@Before
    @Before(value="execution(* cn.huzunjie.spring5.aop.GeneralUser.add(..))")
    public void before() {
        System.out.println("before增强");
    }

    //后置通知：@After
    @After(value="execution(* cn.huzunjie.spring5.aop.GeneralUser.add(..))")
    public void after() {
        System.out.println("after增强");
    }

    //后置通知：@AfterReturning
    @AfterReturning(value="execution(* cn.huzunjie.spring5.aop.GeneralUser.add(..))")
    public void afterReturning() {
        System.out.println("AfterReturning增强");
    }

    //异常通知：@AfterThrowing
    @AfterThrowing(value="execution(* cn.huzunjie.spring5.aop.GeneralUser.add(..))")
    public void afterThrowing() {
        System.out.println("AfterReturning增强");
    }
    //环绕通知：@Around
    @Around(value="execution(* cn.huzunjie.spring5.aop.GeneralUser.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕之前----");
        //被增强的方法执行
        proceedingJoinPoint.proceed();
        System.out.println("环绕之后----");
    }

}

//3、进行通知的配置：
// 1）在spring的配置文件中，开启注解扫描；
// 2)使用注解创建GeneralUser和EnhancedUser；
// 3)在增强类上面添加Aspect注解（生成代理对象）
// 4）在spring配置文件中开启生成代理对象

//4、配置不同类型的通知
//1）在增强类的里面，在作为通知的方法上添加通知类型注解，使用切入点表达式配置




