package cn.huzunjie.spring5.demo.aop;

import cn.huzunjie.spring5.beans.Book;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author HuZunJie
 * @Date 2021/2/6 10:44
 * @Email 826992656@qq.com
 * @Version 1.0
 */

public class AopTestByXml {
    @Test
    public void testAopXml(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("aop-by- xml2.xml");
        Book book = ctx.getBean("book", Book.class);
        book.buy();
    }
}
