package cn.huzunjie.spring5.ioc.annotation;

import cn.huzunjie.spring5.config.SpringConfig;
import cn.huzunjie.spring5.pojo.service.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author HuZunJie
 * @Date 2021/2/4 15:58
 * @Email 826992656@qq.com
 * @Version 1.0
 */

public class PureAnnotationDevDemo {
    //纯注解开发，不需要xml配置文件
    //第一步：创建配置类，替代xml配置文件
    @Test
    public void testPureAnnotationDev(){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = ctx.getBean("userService", UserService.class);
        System.out.println(userService);
        userService.add();

    }
}
