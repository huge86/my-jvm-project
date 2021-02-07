package cn.huzunjie.spring5.demo.features.springtest;

import cn.huzunjie.spring5.service.BankService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author HuZunJie
 * @Date 2021/2/7 9:44
 * @Email 826992656@qq.com
 * @Version 1.0
 */

// spring5基于注解的单元测试,可以整合Junit4,Junit5,testNG

    //整合Junit4案例
@RunWith(SpringJUnit4ClassRunner.class)//指定使用的Junit版本
@ContextConfiguration("classpath:transactions-xml.xml")//指定配置文件的路径,spring加载配置文件,完成容器初始化,对象可以直接使用
public class JUnit4IntegrationByAnnotation {
//    不用getBean()了,spring5自动注入了,可以直接使用
    @Autowired
    private BankService bankService;
    @Test
    public void testJUnit4ByAnnotation(){
        bankService.transferAccountsByException();
    }



}
