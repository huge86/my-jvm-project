package cn.huzunjie.spring5.beans;

/**
 * @Author HuZunJie
 * @Date 2021/2/3 18:15
 * @Email 826992656@qq.com
 * @Version 1.0
 */

public class Dept {
    private String dname;

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "dname='" + dname + '\'' +
                '}';
    }
}
