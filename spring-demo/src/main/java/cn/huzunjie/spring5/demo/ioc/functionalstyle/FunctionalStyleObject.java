package cn.huzunjie.spring5.demo.ioc.functionalstyle;

import org.junit.Test;
import org.springframework.context.support.GenericApplicationContext;

/**
 * @Author HuZunJie
 * @Date 2021/2/7 9:13
 * @Email 826992656@qq.com
 * @Version 1.0
 */

//函数式风格创建对象，交给spring容器进行管理
public class FunctionalStyleObject {
    @Test
    public void testFunctionalStyle(){
        //1.创建GenericApplicationContext对象
        GenericApplicationContext ctx = new GenericApplicationContext();
//        2.调用context的方法注册对象
        ctx.refresh();
//        通过lambda表达式向Spring容器注册自定义的对象
        ctx.registerBean(Banana.class,()->new Banana());
//        3.获取在spring中注册的对象
        //        根据类名的首字母小写,获取不到注册的对象
        //Banana banana = ctx.getBean("banana");
        //根据类的全路径方式注册
        Banana banana = (Banana) ctx.getBean("cn.huzunjie.spring5.demo.ioc.functionalstyle.Banana");
        System.out.println(banana);

    }

    @Test
    public void testFunctionalStyle2(){
        //1.创建GenericApplicationContext对象
        GenericApplicationContext ctx = new GenericApplicationContext();
//        2.调用context的方法注册对象
        ctx.refresh();
//        通过lambda表达式向Spring容器注册自定义的对象,同时指定对象的名字
        ctx.registerBean("b1", Banana.class,()->new Banana());
        Banana b1 = (Banana) ctx.getBean("b1");
        //根据类的全路径方式注册
        System.out.println(b1);

    }

}

class Banana{
    private String address;

}
