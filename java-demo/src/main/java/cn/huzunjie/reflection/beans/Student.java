package cn.huzunjie.reflection.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author HuZunJie
 * @Date 2021/2/5 8:55
 * @Email 826992656@qq.com
 * @Version 1.0
 */


public class Student extends Person{
    public String school;
    private List<String> courses;
    String address;

    public void study(String school){
        System.out.println("我在"+school+"学习Java编程----");
    }
    public static ArrayList<String> showHobby(){
        ArrayList<String> myHobby = new ArrayList<>();
        myHobby.add("篮球");
        myHobby.add("唱歌");
        myHobby.add("编程");
        return myHobby;
    }

    private void goHome(){
        System.out.println("放学了，要回家---");
    }

    public Student(String school, List<String> courses, String address) {
        this.school = school;
        this.courses = courses;
        this.address = address;
    }

    public Student(String name, int age, String school) {
        super(name, age);
        this.school = school;
    }

    private Student(int age, String address) {
        super(age);
        this.address = address;
    }
    private Student(String school, String address) {
        this.school = school;
        this.address = address;
    }
    public Student(){
        super();
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", school='" + school + '\'' +
                ", courses=" + courses +
                ", address='" + address + '\'' +
                '}';
    }
}
