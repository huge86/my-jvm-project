package cn.huzunjie.spring5.aop;

import cn.huzunjie.spring5.dao.CustomerDao;
import cn.huzunjie.spring5.dao.impl.CustomerDaoImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author HuZunJie
 * @Date 2021/2/3 11:52
 * @Version 1.0
 */

//匿名内部类的方式实现JDK动态代理
public class JDKDynamicProxyDemo {
    public static void main(String[] args) {
        //创建接口实现类代理对象
        CustomerDao dynamicProxyObject = (CustomerDao) getDynamicProxyObject(new CustomerDaoImpl());
        dynamicProxyObject.add(2,3);
        dynamicProxyObject.update("Hello,world");

    }

    //通过Proxy.newProxyInstance（）方法的返回值得到代理对象，方法参数是要增强的对象
    public static Object getDynamicProxyObject(final Object target) {

        Object dynamicProxyObject = Proxy.newProxyInstance(   //调用Proxy类中的静态方法，创建代理对象
                target.getClass().getClassLoader(),  //参数1：目标对象的类加载器
                target.getClass().getInterfaces(),   //参数2:目标对象实现的接口
                new InvocationHandler() {            //匿名内部类的方式，回调方法，增强对象

                    @Override  //在该方法中写逻辑代码，增强方法
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("前置增强>>>>>>>>>>>>>>");
                        Object result = method.invoke(target, args);//target是被代理对象
                        System.out.println(result);
                        System.out.println("后置增强<<<<<<<<<<<<<<");
                        return result;
                    }
                });
        return dynamicProxyObject;
    }
}
