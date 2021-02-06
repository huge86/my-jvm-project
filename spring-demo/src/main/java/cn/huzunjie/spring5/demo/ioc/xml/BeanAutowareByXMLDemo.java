package cn.huzunjie.spring5.demo.ioc.xml;

import cn.huzunjie.spring5.beans.Emp;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author HuZunJie
 * @Date 2021/2/3 11:51
 * @Version 1.0
 */

public class BeanAutowareByXMLDemo {
    @Test
    public void testBeanAutoloadByXML(){

        //根据指定的装配规则（属性名或属性类型），spring自动将匹配的属性值注入
        //在实际生产环境中，使用xml做自动装配很少，常使用注解方式实现自动装配
        ApplicationContext context = new ClassPathXmlApplicationContext("autowire.xml");

        //2. 获取配置创建的对象
        Emp emp = context.getBean("emp", Emp.class);

        //3.验证
        System.out.println(emp);

    }
}
