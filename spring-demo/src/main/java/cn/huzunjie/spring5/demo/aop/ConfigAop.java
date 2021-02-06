package cn.huzunjie.spring5.demo.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Author HuZunJie
 * @Date 2021/2/6 10:53
 * @Email 826992656@qq.com
 * @Version 1.0
 */
//纯注解开发,需要创建xml文件
    @Configuration
    @ComponentScan(basePackages = {"cn.huzunjie.spring5"})
    @EnableAspectJAutoProxy(proxyTargetClass = true)
public class ConfigAop {
    //demo
}
