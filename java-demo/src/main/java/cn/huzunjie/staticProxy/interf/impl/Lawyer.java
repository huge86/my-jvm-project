package cn.huzunjie.staticProxy.interf.impl;

import cn.huzunjie.staticProxy.interf.Litigation;

/**
 * @Author HuZunJie
 * @Date 2021/2/5 14:45
 * @Email 826992656@qq.com
 * @Version 1.0
 */

//这是一个代理类
public class Lawyer implements Litigation {
    private String name;
    private Litigation customer;

    public String getName() {
        return name;
    }

    public Lawyer(String name, Litigation customer) {
        this.name = name;
    }

    public Lawyer() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public Litigation getCustomer() {
        return customer;
    }

    public void setCustomer(Litigation customer) {
        this.customer = customer;
    }

    @Override
    public void litigate() {
        System.out.println("我是律师，我正在代理"+customer+"诉讼案件===");
    }

    @Override
    public String toString() {
        return "Lawyer{" +
                "name='" + name + '\'' +
                ", customer=" + customer +
                '}';
    }
}
