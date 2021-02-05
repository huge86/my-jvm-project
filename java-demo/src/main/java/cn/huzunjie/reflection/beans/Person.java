package cn.huzunjie.reflection.beans;

import java.io.Serializable;

/**
 * @Author HuZunJie
 * @Date 2021/2/5 8:55
 * @Email 826992656@qq.com
 * @Version 1.0
 */

public class Person<T> implements Serializable {
    private String name;
    public int age;

    public void sleep(){
        System.out.println("睡觉中----");
    }
    private void eat(){
        System.out.println("private:偷偷吃东西");
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    private Person(String name) {
        this.name = name;
    }
    public Person(int age) {

        this.age = age;
    }
    public Person() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
