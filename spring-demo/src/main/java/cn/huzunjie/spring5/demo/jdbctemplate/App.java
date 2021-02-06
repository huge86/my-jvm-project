package cn.huzunjie.spring5.demo.jdbctemplate;

import cn.huzunjie.spring5.beans.Book;
import cn.huzunjie.spring5.service.BookService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author HuZunJie
 * @Date 2021/2/3 11:52
 * @Version 1.0
 */

//1、什么是JdbcTemplate
//    1)spring框架对jdbc进行了封装，使用JdbcTemplate方便的实现对数据库的操作
//    2）在spring配置文件中配置数据库连接池
//    3）配置JdbcTemplate对象，注入DataSource
//    4)创建service类，创建dao类，在dao注入jdbcTemplate模板
public class App {
//    1、对应数据库表，先创建实体类
//    2、编写service和dao
//      1）在dao进行数据库添加操作
//      2)调用JdbcTemplate对象里面的update方法实现添加操作
    @Test
    //    添加
    public void testJdbcTemplateAdd(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-template.xml");
        BookService bookService = ctx.getBean("bookService", BookService.class);
        Book book = new Book();
        book.setId("1");
        book.setName("php");
        book.setAuthor("lucy");
        bookService.addBook(book);
    }
    //修改
    @Test
    public void testJdbcTemplateUpdate(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-template.xml");
        BookService bookService = ctx.getBean("bookService", BookService.class);
        Book book = new Book();
        book.setId("1");
        book.setName("linux");
        book.setAuthor("job");
        bookService.updateBook(book);
    }

    //    删除
    @Test
    public void testJdbcTemplateDelete(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-template.xml");
        BookService bookService = ctx.getBean("bookService", BookService.class);
        bookService.deleteBook("1");
    }

    //    JdbcTemplate操作数据库，查询返回某个值，例如查询表有多少条纪录
    @Test
    public void testJdbcTemplateSelect1(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-template.xml");
        BookService bookService = ctx.getBean("bookService", BookService.class);
        int count = bookService.findCount();
        System.out.println(count);
    }
    //    JdbcTemplate操作数据库，查询返回对象，例如：查询图书详情，图书详情是一个BookDetails类的对象
    @Test
    public void testJdbcTemplateSelect2(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-template.xml");
        BookService bookService = ctx.getBean("bookService", BookService.class);
        Book book = bookService.findOne("1");
        System.out.println(book);

    }
    //    JdbcTemplate操作数据库，查询返回集合,例如：查询图书列表，分页等等
    @Test
    public void testJdbcTemplateSelect3(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-template.xml");
        BookService bookService = ctx.getBean("bookService", BookService.class);
        List<Book> all = bookService.findAll();
        System.out.println(all);
    }

    //    JdbcTemplate操作数据库，批量操作：例如，批量添加
    @Test
    public void testJdbcTemplateSelect4(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-template.xml");
        BookService bookService = ctx.getBean("bookService", BookService.class);
        List<Object[]> batchArgs = new ArrayList<>();
        Object[] o1 = {"5","C#","join"};
        Object[] o2 = {"6","js","nana"};
        Object[] o3 = {"7","rust","longlong"};
        batchArgs.add(o1);
        batchArgs.add(o2);
        batchArgs.add(o3);
        bookService.batchAdd(batchArgs);
    }

    //    JdbcTemplate操作数据库，批量修改
    @Test
    public void testJdbcTemplateSelect5(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-template.xml");
        BookService bookService = ctx.getBean("bookService", BookService.class);
        List<Object[]> batchArgs = new ArrayList<>();
        Object[] o1 = {"音乐1","王五1","3"};
        Object[] o2 = {"体育1","马六1","4"};
        Object[] o3 = {"绘画1","刘琦1","5"};
        batchArgs.add(o1);
        batchArgs.add(o2);
        batchArgs.add(o3);
        bookService.batchUpdate(batchArgs);
    }

    //    JdbcTemplate操作数据库，批量删除
    @Test
    public void testJdbcTemplateSelect6(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-template.xml");
        BookService bookService = ctx.getBean("bookService", BookService.class);
        List<Object[]> batchArgs = new ArrayList<>();
        Object[] o1 = {"5"};
        Object[] o2 = {"6"};
        Object[] o3 = {"7"};
        batchArgs.add(o1);
        batchArgs.add(o2);
        batchArgs.add(o3);
        bookService.batchDelete(batchArgs);
    }
}
