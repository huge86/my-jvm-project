package cn.huzunjie.staticProxy.interfaces.impl;

import cn.huzunjie.staticProxy.interfaces.NvShen;

/**
 * @Author HuZunJie
 * @Date 2021/2/5 15:56
 * @Email 826992656@qq.com
 * @Version 1.0
 */
//朋友，她的闺蜜是小曼,朋友相当于一个代理
public class Friend implements NvShen {
    private String name;

    public Friend(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    private NvShen nvShen;
    public Friend(NvShen nvShen){
        this.nvShen = nvShen;
    }
    public Friend(String name, NvShen nvShen){
        this.name = name;
        this.nvShen = nvShen;
    }
    @Override
    public void eat() {
        System.out.println("我是"+getName()+"我带着闺蜜来吃饭了");
        //调用被代理对象的eat()方法
        nvShen.eat();
    }
}
