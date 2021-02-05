package cn.huzunjie.staticProxy.interfaces.impl;

import cn.huzunjie.staticProxy.interfaces.ClothFactory;

/**
 * @Author HuZunJie
 * @Date 2021/2/5 16:44
 * @Email 826992656@qq.com
 * @Version 1.0
 */
//被代理类
public class NikeClothFactory implements ClothFactory {
    @Override
    public void produceCloth() {
        System.out.println("Nike工厂生产了一批运动服====");
    }
}
