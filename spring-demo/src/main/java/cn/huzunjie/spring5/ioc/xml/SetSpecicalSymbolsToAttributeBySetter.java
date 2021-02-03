package cn.huzunjie.spring5.ioc.xml;

import cn.huzunjie.spring5.beans.Book;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author HuZunJie
 * @Date 2021/2/3 15:34
 * @Version 1.0
 */

public class SetSpecicalSymbolsToAttributeBySetter {
    @Test
    public void testBookBean(){


        //BeanFactory不会在加载配置文件的时候，创建对象，在使用对象的时候，才创建
        BeanFactory ctx = new ClassPathXmlApplicationContext("specialSymbolInbooks.xml");
        //2. 获取配置创建的对象
        Book book = ctx.getBean("book", Book.class);

        //3.验证
        System.out.println(book.getName());
        System.out.println(book.getAuthor());


    }
}
