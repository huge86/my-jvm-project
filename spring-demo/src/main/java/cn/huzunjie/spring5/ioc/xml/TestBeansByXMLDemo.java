package cn.huzunjie.spring5.ioc.xml;

import cn.huzunjie.spring5.beans.User;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author HuZunJie
 * @Date 2021/2/3 11:51
 * @Version 1.0
 */

public class TestBeansByXMLDemo {
    @Test
    public void testUserBean(){
        //1. load spring settings file
        //ApplicationContext在加载配置文件的时候，就创建对象,项目中较常用，可以实现项目启动的时候，实例化对象
        //ApplicationContext是接口，常用实现类：FileSystemXmlApplication,ClassPathXmlApplicationContext
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        //BeanFactory不会在加载配置文件的时候，创建对象，在使用对象的时候，才创建
        BeanFactory ctx = new ClassPathXmlApplicationContext("beans.xml");
        //2. 获取配置创建的对象
        User user = context.getBean("user", User.class);

        //3.验证
        System.out.println(user);
        System.out.println(ctx.getBean("user", User.class));
        user.add();

    }
}
