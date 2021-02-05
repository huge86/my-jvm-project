package cn.huzunjie.dynamicproxies;

import cn.huzunjie.staticProxy.interfaces.ClothFactory;
import cn.huzunjie.staticProxy.interfaces.impl.NikeClothFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author HuZunJie
 * @Date 2021/2/5 14:03
 * @Email 826992656@qq.com
 * @Version 1.0
 */

public class DynamicProxyTest {
//    代理设计模式的原理：使用一个代理对象将被代理的对象包装起来，然后使用该代理对象取代原始对象。
//    任何对原始对象的调用都要通过代理，代理对象决定是否以及何时将方法调用转到原始对象上。
//    静态代理：代理类和被代理类都是在编译期间就确定下来的，不利于程序的扩展。同时，每一个代理类只能为一个借口服务，这样一来
//    程序开发中必然产生过多的代理。最好通过一个代理类完成全部的代理功能

    /*
    * 要想实现动态代理，需要解决的问题：
    * 问题一：如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象；
    * 问题二：当通过代理类的对象调用方法时，如何动态的去调用被代理类中的同名方法
    * */
    public static void main(String[] args) {
        SuperMan superMan = new SuperMan("成龙");
//        proxyInstance代理类的对象
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
        //当通过代理类对象调用方法时，会自动的调用被代理类中同名的方法
        String belief = proxyInstance.getBelief();
        System.out.println(belief);
        proxyInstance.eat("湘菜");

        System.out.println("*****************************");

        NikeClothFactory nikeClothFactory = new NikeClothFactory();
        ClothFactory nikeProxy = (ClothFactory) ProxyFactory.getProxyInstance(nikeClothFactory);
        nikeProxy.produceCloth();

    }
}

class ProxyFactory{

    //调用此方法，返回一个代理类的对象，解决问题一
    public static Object getProxyInstance(Object obj){//obj被代理类的对象
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),
                handler);//解决问题二：当我们通过代理类的对象，调用方法a时，就会自动调用如下方法invoke()方法
    }
}
class MyInvocationHandler implements InvocationHandler{
    private Object obj;//需要为被代理类的对象赋值
    public void bind(Object obj){
        this.obj = obj;
    }
    //解决问题二：当我们通过代理类的对象，调用方法a时，就会自动调用如下方法invoke()方法
    //将被代理类要执行的方法a的功能声明在invoke()方法中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //method：即为代理类对象调用的方法，此方法也就作为了被代理类要调用的方法
        //obj:被代理类的对象
        //此方法的返回值就作为当前类中的invoke（）方法的返回值
        HumanUtil util = new HumanUtil();
        util.method1();
        Object returnValue = method.invoke(obj, args);
        util.method2();
        return returnValue;
    }
}
//接口
interface Human{
    String getBelief();
    void eat(String food);
}

class HumanUtil{
    public void method1(){
        System.out.println("#######通用方法一############");
    }
    public void method2(){
        System.out.println("********通用方法二************");
    }
}

//被代理类
class SuperMan implements Human{
    private String name;

    public SuperMan(String name) {
        this.name = name;
    }
    public SuperMan() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getBelief() {
        return "I believe I can fly";
    }

    @Override
    public void eat(String food) {
        System.out.println("超人喜欢吃"+food);
    }

    @Override
    public String toString() {
        return "SuperMan{" +
                "name='" + name + '\'' +
                '}';
    }
}
