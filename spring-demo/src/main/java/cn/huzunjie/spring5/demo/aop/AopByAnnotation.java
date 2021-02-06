package cn.huzunjie.spring5.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author HuZunJie
 * @Date 2021/2/5 19:55
 * @Email 826992656@qq.com
 * @Version 1.0
 */

public class AopByAnnotation {
    //同一个方法的增强类有多个，都会执行，可以设定优先级，指定增强类的执行顺序
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

//2、创建增强类，创建方法，让不同的方法代表不同类型的通知；如果有多个增强类对同一个方法进行增强，可以设置增强类的优先级
@Component
@Aspect
@Order(3)
class EnhancedUser {
    //相同切入点抽取，下面的每个增强方法的切入点表达式一样，可以提出出来，复用；好处，修改时，修改一处即可
    //1、定义一个普通方法，名字随便起
    //2、该方法上面添加@Pointcut注解
    //3、增强方法中使用
    @Pointcut(value="execution(* cn.huzunjie.spring5.demo.aop.GeneralUser.add(..))")
    public void pointDemo(){

    }

    //前置通知：@Before
    @Before(value="pointDemo()")
    public void before() {
        System.out.println("before增强1");
    }

    //后置通知：@After
    @After(value="pointDemo()")
    public void after() {
        System.out.println("after增强1");
    }

    //后置通知：@AfterReturning
    @AfterReturning(value="execution(* cn.huzunjie.spring5.demo.aop.GeneralUser.add(..))")
    public void afterReturning() {
        System.out.println("AfterReturning增强1");
    }

    //异常通知：@AfterThrowing
    @AfterThrowing(value="execution(* cn.huzunjie.spring5.demo.aop.GeneralUser.add(..))")
    public void afterThrowing() {
        System.out.println("AfterReturning增强1");
    }
    //环绕通知：@Around
    @Around(value="execution(* cn.huzunjie.spring5.demo.aop.GeneralUser.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕1之前----");
        //被增强的方法执行
        proceedingJoinPoint.proceed();
        System.out.println("环绕1之后----");
    }

}
//第二个增强类，可以在增强类上面添加注解@Order(数字类型值)，数字越低，优先级越高
@Component
@Aspect
@Order(1)
class EnhancedUser2 {
    //相同切入点抽取，下面的每个增强方法的切入点表达式一样，可以提出出来，复用；好处，修改时，修改一处即可
    //1、定义一个普通方法，名字随便起
    //2、该方法上面添加@Pointcut注解
    //3、增强方法中使用
    @Pointcut(value="execution(* cn.huzunjie.spring5.demo.aop.GeneralUser.add(..))")
    public void pointDemo(){

    }

    //前置通知：@Before
    @Before(value="pointDemo()")
    public void before() {
        System.out.println("before增强2");
    }

    //后置通知：@After
    @After(value="pointDemo()")
    public void after() {
        System.out.println("after增强2");
    }

    //后置通知：@AfterReturning
    @AfterReturning(value="execution(* cn.huzunjie.spring5.demo.aop.GeneralUser.add(..))")
    public void afterReturning() {
        System.out.println("AfterReturning增强2");
    }

    //异常通知：@AfterThrowing
    @AfterThrowing(value="execution(* cn.huzunjie.spring5.demo.aop.GeneralUser.add(..))")
    public void afterThrowing() {
        System.out.println("AfterReturning增强2");
    }
    //环绕通知：@Around
    @Around(value="execution(* cn.huzunjie.spring5.demo.aop.GeneralUser.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("2环绕之前----");
        //被增强的方法执行
        proceedingJoinPoint.proceed();
        System.out.println("2环绕之后----");
    }

}

//3、进行通知的配置：
// 1）在spring的配置文件中，开启注解扫描；
// 2)使用注解创建GeneralUser和EnhancedUser；
// 3)在增强类上面添加Aspect注解（生成代理对象）
// 4）在spring配置文件中开启生成代理对象

//4、配置不同类型的通知
//1）在增强类的里面，在作为通知的方法上添加通知类型注解，使用切入点表达式配置




