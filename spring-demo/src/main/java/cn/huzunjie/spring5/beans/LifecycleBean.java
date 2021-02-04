package cn.huzunjie.spring5.beans;

/**
 * @Author HuZunJie
 * @Date 2021/2/4 11:11
 * @Email 826992656@qq.com
 * @Version 1.0
 */

public class LifecycleBean {
    private String lname;

    public LifecycleBean() {
        System.out.println("第一步：调用无参构造器创建bean实例----");
    }

    public String getLname() {
        return lname;
    }


    public void setLname(String lname) {
        this.lname = lname;
        System.out.println("第二步：调用set方法设置属性值---");
    }

    //创建初始化的执行方法：在bean的配置文件中，bean标签配置init-method属性，值为initMethod
    public void initMethod(){
        System.out.println("第三步：调用初始化方法---");
    }
    //创建销毁的执行方法，在bean的配置文件中，bean标签配置destroy-method属性，值为destroyMethod
    public void destroyMethod(){
        System.out.println("第五步：调用销毁的执行方法---");
    }
    @Override
    public String toString() {
        return "LifecycleBean{" +
                "lname='" + lname + '\'' +
                '}';
    }
}
