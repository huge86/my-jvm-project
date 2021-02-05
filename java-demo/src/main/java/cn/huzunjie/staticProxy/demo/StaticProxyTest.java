package cn.huzunjie.staticProxy.demo;

import cn.huzunjie.staticProxy.interf.ClothFactory;
import cn.huzunjie.staticProxy.interf.impl.*;
import org.junit.jupiter.api.Test;

/**
 * @Author HuZunJie
 * @Date 2021/2/5 14:11
 * @Email 826992656@qq.com
 * @Version 1.0
 */

public class StaticProxyTest {
    /*
    * 代理模式：为对象提供一种代理，以控制对这个对象的访问，例如，如果要调用某个对象的方法，代理模式中，不直接调用
    * 该对象了，通过调用某对象的代理对象，代理对象再调用某对象的方法，来实现调用者与某对象的解耦*/
    
    /*
    * 一单身狗看上了朋友的闺蜜，担心直接约女神吃饭被拒，因此单身狗请朋友吃饭，让朋友顺便带着她的闺蜜*/

    public static void main(String[] args) {
        //初始化
        XiaoMan xiaoMan = new XiaoMan("小曼");
        Friend naNa = new Friend("娜娜",xiaoMan);
        DamnSingle damnSingle = new DamnSingle(naNa);
        damnSingle.makeFriend();


    }
    @Test
    public void testClothFactoryProxy(){
        //先造一个被代理对象
        NikeClothFactory nike = new NikeClothFactory();
        //创建代理，传入被代理对象
        ClothFactory proxy = new ClothFactoryProxy(nike);
        proxy.produceCloth();


    }

}
