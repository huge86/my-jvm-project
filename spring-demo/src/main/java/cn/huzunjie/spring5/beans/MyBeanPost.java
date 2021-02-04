package cn.huzunjie.spring5.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;

/**
 * @Author HuZunJie
 * @Date 2021/2/4 9:45
 * @Email 826992656@qq.com
 * @Version 1.0
 */

public class MyBeanPost implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("在初始化方法之前，执行的方法****");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("在初始化方法之后，执行的方法****");
        return bean;
    }

}
