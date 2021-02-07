package cn.huzunjie.spring5.demo.features.springtest;

import cn.huzunjie.spring5.service.BankService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author HuZunJie
 * @Date 2021/2/7 10:07
 * @Email 826992656@qq.com
 * @Version 1.0
 */

//@ExtendWith(SpringExtension.class)//spring5整合Junit5
//@ContextConfiguration("classpath:transactions-xml.xml")//指定配置文件的路径,spring加载配置文件,完成容器初始化,对象可以直接使用
@SpringJUnitConfig(locations="classpath:transactions-xml.xml")//此注解可以代替上面两个注解,spring5的新特性
public class JUnit5IntegrationByAnnotation {
    @Autowired
    private BankService bankService;
    @Test//JUnit5中的
    public void testJUnit5ByAnnotation(){
        bankService.transferAccountsByException();
    }
}
