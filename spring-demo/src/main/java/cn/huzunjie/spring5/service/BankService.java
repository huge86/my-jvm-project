package cn.huzunjie.spring5.service;

import cn.huzunjie.spring5.dao.BankDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author HuZunJie
 * @Date 2021/2/6 16:02
 * @Email 826992656@qq.com
 * @Version 1.0
 */

@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
public class BankService {
    //注入BankDao
    @Autowired
    private BankDao bankDao;

    //转账的方法：一切顺利，正常转账
    public void transferAccounts(){
        //lucy少100
        bankDao.reduceMoney();
        //mary多100
        bankDao.addMoney();

    }

    //转账的方法：出现异常
    public void transferAccountsByException(){
        //lucy少100
        bankDao.reduceMoney();
        //        模拟异常
        int i = 100 / 0;
        //mary多100
        bankDao.addMoney();

    }

    //转账的方法：事务控制，事务一般添加到J2EE三层结构里面的service层
//    在spring中进行事务的管理操作：
//    1、有两种方式：编程式事务管理、声明式事务管理（常用）
//    2、声明式事务管理的方式：1）基于注解方式；2）基于xml配置文件的方式
//    3、spring中的声明式事务管理，底层采用AOP
//    4、spring事务管理API
//        1)提供一个接口，代表事务管理器，这个接口针对不同的框架提供不同的实现类；
//        2）
    public void transferAccountsByProgrammingTransaction(){
        try {
            //第一步：开启事务
            //第二步：进行业务上的操作
            //lucy少100
            bankDao.reduceMoney();
            //        模拟异常
            int i = 100 / 0;
            //mary多100
            bankDao.addMoney();
            //第三步：没有发生异常，提交事务

        }catch (Exception e){
            //第四步：发生异常，回滚事务

        }

    }

    public void transferAccountsByStatementTransaction(){


    }

}
