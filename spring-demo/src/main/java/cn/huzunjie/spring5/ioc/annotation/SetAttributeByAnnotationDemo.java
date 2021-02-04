package cn.huzunjie.spring5.ioc.annotation;


import cn.huzunjie.spring5.pojo.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author HuZunJie
 * @Date 2021/2/4 15:33
 * @Email 826992656@qq.com
 * @Version 1.0
 */

public class SetAttributeByAnnotationDemo {
    @Test
    public void testSetAttributeByAnnotation(){
        //基于注解的方式，实现属性注入
        //1)对象类型注入
        //1、@AutoWired 根据属性类型进行自动装配
        //2、@Qualifier 根据属性名称自动装配
        //3、@Resource  可名称可类型自动装配
        //2）普通类型注入
        //1、@Value 注入普通类型属性

        //步骤
        //第一步：把service和dao对象创建，在service和dao类添加创建对象的注解
        //第二步：在service里面注入dao对象,在service类添加dao类型属性，在属性上面使用注解@AutoWired，service类不需要添加set方法
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("set-attribute-by-annotation.xml");
        UserService userService = ctx.getBean("userService", UserService.class);
        System.out.println(userService);
        userService.add();
    }

    @Test
    public void testSetAttributeByAnnotation2(){
        //@Qualifier注解的使用，和@Autowired一起使用
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("set-attribute-by-annotation-qualifier.xml");
        UserService userService = ctx.getBean("userService", UserService.class);
        System.out.println(userService);
        userService.add();
    }
}
