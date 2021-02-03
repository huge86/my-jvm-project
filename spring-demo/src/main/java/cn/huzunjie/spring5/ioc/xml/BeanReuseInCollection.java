package cn.huzunjie.spring5.ioc.xml;


import cn.huzunjie.spring5.beans.Hobby;
import cn.huzunjie.spring5.beans.Student;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author HuZunJie
 * @Date 2021/2/3 15:34
 * @Version 1.0
 */

public class BeanReuseInCollection {
    @Test
    public void testBeanReuseInCollection(){


        //在集合里面设置对象类型
        BeanFactory ctx = new ClassPathXmlApplicationContext("bean-reuse-in-collection.xml");
        //2.
        Hobby  hobby = ctx.getBean("hobby", Hobby.class);

        //3.验证
        System.out.println(hobby);



    }
}
