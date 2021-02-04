package cn.huzunjie.spring5.ioc.annotation;

import cn.huzunjie.spring5.beans.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author HuZunJie
 * @Date 2021/2/4 14:26
 * @Email 826992656@qq.com
 * @Version 1.0
 */

public class SpringAnnotationDemo {
    //spring针对Bean管理创建对象提供了4中类型
    //@Componet 通用对象创建
    //@Service  用户业务逻辑层或者service层对象的创建
    //@Controller 用于web层
    //@Repository 用于dao层

    @Test
    public void testSpringAnnotation(){
        //第一步；引入aop依赖
        //第二步；开启组件扫描
        //第三步：创建类，在类上面添加创建对象的注解
        //测试
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("annotation.xml");
        UserService userService = ctx.getBean("userService", UserService.class);
        System.out.println(userService);
        userService.add();
    }


}
