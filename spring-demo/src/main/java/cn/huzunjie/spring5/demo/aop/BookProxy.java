package cn.huzunjie.spring5.demo.aop;

/**
 * @Author HuZunJie
 * @Date 2021/2/6 8:55
 * @Email 826992656@qq.com
 * @Version 1.0
 */

//cn.huzunjie.spring5.beans.Book类的增强类
public class BookProxy {
    public void before(){
        System.out.println("before增强-----");
    }
}
