package cn.huzunjie.staticProxy.interf.impl;

import cn.huzunjie.staticProxy.interf.NvShen;

/**
 * @Author HuZunJie
 * @Date 2021/2/5 16:02
 * @Email 826992656@qq.com
 * @Version 1.0
 */

public class DamnSingle {
    private NvShen nvShen;
    public DamnSingle(NvShen nvShen){
        this.nvShen = nvShen;
    }
    /*
    * 交朋友*/
    public void makeFriend(){
        nvShen.eat();

        System.out.println("我是单身狗，我与朋友的闺蜜聊天---");

    }
}
