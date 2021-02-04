package cn.huzunjie.spring5.ioc.xml;

import cn.huzunjie.spring5.beans.LifecycleBean;
import cn.huzunjie.spring5.beans.Order;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author HuZunJie
 * @Date 2021/2/4 10:48
 * @Email 826992656@qq.com
 * @Version 1.0
 */

public class BeanLifecycleDemo {

    @Test
    public  void testBeanLifecycle(){
        //默认单例模式，可配置为多实例模式
        BeanFactory ctx = new ClassPathXmlApplicationContext("orders.xml");
        Order order1 = ctx.getBean("order", Order.class);
        Order order2 = ctx.getBean("order", Order.class);
        System.out.println(order1);
        System.out.println(order2);

    }

    @Test
    public  void testBeanLifecycle2(){
        //配置为多实例模式,spring配置文件里面的bean标签有scope属性，可以用于设置多实例
        //设置scope是singleton的时候，加载spring配置文件时，就会创建单实例对象，设置scope值是prototype的时候，加载spring配置文件
        //不创建对象，调用getBean方法时创建多实例对象
        BeanFactory ctx = new ClassPathXmlApplicationContext("orders-prototype.xml");
        Order order1 = ctx.getBean("order", Order.class);
        Order order2 = ctx.getBean("order", Order.class);
        System.out.println(order1);
        System.out.println(order2);

    }
    //request 一次请求有效
    //session 会话中有效

    @Test
    public  void testBeanLifecycle3(){
        //生命周期测试
        //bean的生命周期：
        //    1、通过构造器创建bean实例（无参构造）
        //    2、为bean属性赋值，value类型或者ref 类型（调用set方法）
        //    3、调用bean的初始化方法（需要配置初始化方法）
        //    4、对象获取到了，bean可以使用了
        //    5、当容器关闭的时候，调用bean的销毁方法（销毁方法需要配置）
        BeanFactory ctx = new ClassPathXmlApplicationContext("BeanLifecycle.xml");
        LifecycleBean lifecycleBean = ctx.getBean("lifecycleBean", LifecycleBean.class);
        System.out.println("第四步：获取创建的bean实例对象---");
        System.out.println(lifecycleBean);
        //手动让bean的实例销毁，只有实例销毁了，才会触发自定义的销毁方法
        ((ClassPathXmlApplicationContext) ctx).close();

    }

    @Test
    public  void testBeanLifecycle4(){
        //bean后置处理器
        //bean的生命周期：
        //    1、通过构造器创建bean实例（无参构造）
        //    2、为bean属性赋值，value类型或者ref 类型（调用set方法）
        //      把bean的实例传递给bean后置处理器的方法
        //    3、调用bean的初始化方法（需要配置初始化方法）
        //      把bean的实例传递给bean后置处理器的方法
        //    4、对象获取到了，bean可以使用了
        //    5、当容器关闭的时候，调用bean的销毁方法（销毁方法需要配置）
        BeanFactory ctx = new ClassPathXmlApplicationContext("BeanLifecyclePostBean.xml");
        LifecycleBean lifecycleBean = ctx.getBean("lifecycleBean", LifecycleBean.class);
        System.out.println("第四步：获取创建的bean实例对象---");
        System.out.println(lifecycleBean);
        //手动让bean的实例销毁，只有实例销毁了，才会触发自定义的销毁方法
        ((ClassPathXmlApplicationContext) ctx).close();

    }


}
