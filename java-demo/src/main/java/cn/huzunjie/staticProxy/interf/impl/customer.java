package cn.huzunjie.staticProxy.interf.impl;

import cn.huzunjie.staticProxy.interf.Litigation;

/**
 * @Author HuZunJie
 * @Date 2021/2/5 15:22
 * @Email 826992656@qq.com
 * @Version 1.0
 */
//客户，有诉讼诉求
public class customer implements Litigation {
    private String name;

    public customer(String name) {
        this.name = name;
    }
    public customer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void litigate() {
        System.out.println("诉讼维权");
    }
}
