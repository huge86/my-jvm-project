package cn.huzunjie.staticProxy.interf.impl;

import cn.huzunjie.staticProxy.interf.NvShen;

/**
 * @Author HuZunJie
 * @Date 2021/2/5 15:55
 * @Email 826992656@qq.com
 * @Version 1.0
 */
//梦中女神
public class XiaoMan implements NvShen {
    private String name;

    public XiaoMan(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void eat() {
        System.out.println("我是"+getName()+"我在吃饭---");
    }
}
