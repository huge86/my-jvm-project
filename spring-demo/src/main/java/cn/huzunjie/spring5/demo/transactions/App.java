package cn.huzunjie.spring5.demo.transactions;

import cn.huzunjie.spring5.config.TxConfig;
import cn.huzunjie.spring5.service.BankService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.retry.policy.NeverRetryPolicy;

import java.io.Serializable;

/**
 * @Author HuZunJie
 * @Date 2021/2/6 15:45
 * @Email 826992656@qq.com
 * @Version 1.0
 */

//银行转正例子
public class App {

    @Test
    public void testTransferAccounts(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("transactions.xml");
        BankService bankService = ctx.getBean("bankService", BankService.class);
        bankService.transferAccounts();
    }

    @Test
    public void transferAccountsByTransaction(){
//        1、在spring配置文件中配置事务管理器，引入tx命名空间；
//        2、在spring配置文件中，开启事务注解;
//        3、在service类或者类里面的方法上添加事务注解
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("transactions.xml");
        BankService bankService = ctx.getBean("bankService", BankService.class);
        //bankService.transferAccountsByStatementTransaction();
        bankService.transferAccountsByException();
    }

    @Test
    public void testTransactionparameters(){
//  声明式事务管理参数配置：@Transactional可以配置事务相关参数
//        1、propagation：事务的传播行为:多事务方法直接进行调用，这个过程中事务是如何进行管理的
//                事务方法（操作）：对数据库中数据表数据进行变化的操作，称为事务操作，例如：增、删、改，查询不属于事务性操作；
//                例如：增、改都是事务性操作，如果增加方法中调用了修改方法，那么@Transactional添加到增，不添加到改，或者两者都加，有何影响
//                事务的传播行为可以由传播属性指定，spring定义了7种传播行为：
//                1、required(默认)：@Transactional(propagation = Propagation.REQUIRED)有事务，则在当前事务中运行，否则创建一个新事务，
//                   在这个新事务中运行。内方法看看外方法有没有事务，有则在外方法的事务中运行，否则内方法新建一个事务，然后在新建的事务中运行；
//                2、required_new：必须新建一个事务，并在新事务中运行，如果启动新事务前，已经运行在旧的事务中了，则把旧事务挂起
//                3、supports：如果有事务在运行，当前方法就在这个事务内运行，否则他可以不运行在事务中
//                4、not_supports：当前的方法不运行在事务中，如果有运行的事务，则将它挂起；
//                5、mandatory：当前的方法必须运行在事务内部，如果没有正在运行的事务，就抛出异常；
//                6、Never：当前方法不运行在事务中，如果有运行的事务，就抛出异常；
//                7、nested：如果有事务在运行，当前的方法就应该在这个事务的嵌套事务内运行，否则就启动一个新的事务，并在它自己的事务内运行。
//        2、isolation：事务隔离级别，通过设置事务的隔离性，解决读的三个问题，默认：可重复读
//              @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ):
//              1）事务有个特性，称为隔离性，多事务操作之间不会产生影响；不考虑隔离性会产生很多问题：有三个问题；脏读、不可重复读、虚（幻）读
//                脏读：一个未提交事务读取到另一个未提交事务的数据；
//                不可重复读：一个未提交事务读取到另一提交事务修改数据
//                虚读：一个未提交事务读取到另一提交事务添加的数据
//                read uncommitted：读未提交，三个问题都存在
//                read committed：读已提交，只能解决脏读问题
//                repeatable read：可重复读，无法解决幻读
//                Serializable：串行化，三个问题全解决
//        3、timeout：超时时间：在多长时间内进行提交，如果不提交，则回滚。默认值：-1  以秒为单位
//        4、readOnly：是否只读，默认值：false。如果设置为true，则只能查询，不能增、删、改
//        5、rollbackFor：回滚：设置出现哪些异常进行事务回滚
//        6、noRollbackFor:不回滚：设置出现哪些异常不进行事务回滚
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("transactions.xml");
        BankService bankService = ctx.getBean("bankService", BankService.class);
        //bankService.transferAccountsByStatementTransaction();
        bankService.transferAccountsByException();
    }

    @Test
    public void testXmlTransaction(){
//        事务操作（xml声明式事务管理）
//        在spring配置文件中进行配置
//        1、配置事务管理器
//        2、配置通知（增强的部分）
//        3、配置切入点、切面
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("transactions-xml.xml");
        BankService bankService = ctx.getBean("bankService", BankService.class);
        //bankService.transferAccountsByStatementTransaction();
        bankService.transferAccountsByException();
    }

    @Test
    public void testTransactionByPureAnnotation(){
//        事务操作（xml声明式事务管理）
//        在spring配置文件中进行配置
//        1、配置事务管理器
//        2、配置通知（增强的部分）
//        3、配置切入点、切面
        ApplicationContext ctx = new AnnotationConfigApplicationContext(TxConfig.class);
        BankService bankService = ctx.getBean("bankService", BankService.class);
        //bankService.transferAccountsByStatementTransaction();
        bankService.transferAccountsByException();
    }

}
