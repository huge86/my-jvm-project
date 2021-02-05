package cn.huzunjie.staticProxy.interfaces.impl;

import cn.huzunjie.staticProxy.interfaces.ClothFactory;

/**
 * @Author HuZunJie
 * @Date 2021/2/5 16:40
 * @Email 826992656@qq.com
 * @Version 1.0
 */

//代理类
public  class ClothFactoryProxy implements ClothFactory {
    private ClothFactory clothFactory;//用被代理类对象进行实例化

    public ClothFactoryProxy(ClothFactory clothFactory) {
        this.clothFactory = clothFactory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂做一些准备工作");
        clothFactory.produceCloth();
        System.out.println("代理工厂做一些后续的收尾工作");



    }
}
