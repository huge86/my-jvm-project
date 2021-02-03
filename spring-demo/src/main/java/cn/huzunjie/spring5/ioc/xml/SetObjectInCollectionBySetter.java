package cn.huzunjie.spring5.ioc.xml;


import cn.huzunjie.spring5.beans.Student;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author HuZunJie
 * @Date 2021/2/3 15:34
 * @Version 1.0
 */

public class SetObjectInCollectionBySetter {
    @Test
    public void testSetObjectInCollectionBySetter(){


        //在集合里面设置对象类型
        BeanFactory ctx = new ClassPathXmlApplicationContext("set-object-type-in-collection.xml");
        //2.
        Student  student = ctx.getBean("student", Student.class);

        //3.验证
        System.out.println(student);



    }
}
