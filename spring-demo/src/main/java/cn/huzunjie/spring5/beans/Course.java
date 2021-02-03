package cn.huzunjie.spring5.beans;

/**
 * @Author HuZunJie
 * @Date 2021/2/3 19:35
 * @Email 826992656@qq.com
 * @Version 1.0
 */

public class Course {
    private String cname;
    public void setCname(String cname){
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cname='" + cname + '\'' +
                '}';
    }
}
