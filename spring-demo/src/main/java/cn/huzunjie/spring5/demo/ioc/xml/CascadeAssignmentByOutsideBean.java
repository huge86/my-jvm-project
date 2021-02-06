package cn.huzunjie.spring5.demo.ioc.xml;

import cn.huzunjie.spring5.beans.Emp;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author HuZunJie
 * @Date 2021/2/3 18:38
 * @Email 826992656@qq.com
 * @Version 1.0
 */

public class CascadeAssignmentByOutsideBean {
    @Test
    public void testCascadeAssignmentByOutsideBean(){


        //BeanFactory不会在加载配置文件的时候，创建对象，在使用对象的时候，才创建
        BeanFactory ctx = new ClassPathXmlApplicationContext("one-to-many-outside-bean.xml");
        //2. 获取配置创建的对象
        Emp emp = ctx.getBean("emp", Emp.class);

        //3.验证
        System.out.println(emp);



    }
}
