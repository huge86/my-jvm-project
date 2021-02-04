package cn.huzunjie.spring5.ioc.xml;

import cn.huzunjie.spring5.beans.Course;
import cn.huzunjie.spring5.beans.MyBean;
import org.junit.Test;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author HuZunJie
 * @Date 2021/2/4 9:45
 * @Email 826992656@qq.com
 * @Version 1.0
 */

public class FactoryBeanDemo {
    //普通bean:在配置文件中定义的bean类型就是返回类型；
    //factorybean:在配置文件中定义的bean类型可以和返回类型不一致
    @Test
    public void testFactoryBean(){
        ClassPathXmlApplicationContext ctx =
                new ClassPathXmlApplicationContext("FactoryBean.xml");
//        MyBean myBean = ctx.getBean("myBean", MyBean.class);
//        System.out.println(myBean);
        Course course = ctx.getBean("myBean", Course.class);
        System.out.println(course);

    }

}
