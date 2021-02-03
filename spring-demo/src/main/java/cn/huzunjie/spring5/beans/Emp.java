package cn.huzunjie.spring5.beans;

/**
 * @Author HuZunJie
 * @Date 2021/2/3 18:17
 * @Email 826992656@qq.com
 * @Version 1.0
 */

public class Emp {
    private String ename;
    private String gender;
    private Dept dept;



    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "ename='" + ename + '\'' +
                ", gender='" + gender + '\'' +
                ", dept=" + dept +
                '}';
    }
}
