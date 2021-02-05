package cn.huzunjie.reflection.demo;

import cn.huzunjie.reflection.beans.Student;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @Author HuZunJie
 * @Date 2021/2/5 11:27
 * @Email 826992656@qq.com
 * @Version 1.0
 */
  /*
        * 调用运行时类中指定的结构：属性、方法、构造器
          返回结果示例：
        * */
public class CallRuntimeClassStructuresInReflection {


    //获取指定的属性
    @Test
    public void testField() throws Exception {

        Class clazz = Student.class;
        //获取指定的属性
        Field school = clazz.getField("school");
        //保证当前属性是可访问的
        school.setAccessible(true);
        //创建运行时类的对象
        Student student = (Student) clazz.newInstance();
        //设置当前属性的值
        school.set(student,"衡水一中");
        //获取当前属性的值
        String name = (String) school.get(student);
        System.out.println(name);
    }

    //获取指定的方法
    @Test
    public void testMethod() throws Exception {

        Class clazz = Student.class;

        //创建运行时类的对象
        Student student = (Student) clazz.newInstance();

        //获取指定的某个方法:getDeclaredMethod  参数1：指明要获取方法的名称，参数2：获取指定方法的形参列表，因为方法可能重载
        Method study = clazz.getDeclaredMethod("study", String.class);
        //保证当前属性是可访问的
        study.setAccessible(true);
        //invoke(): 参数1：方法的调用者   参数2:给方法形参赋值的实参
        //invoke()方法的返回值，就是对应类中调用方法的返回值
        Object returnValue = study.invoke(student, "尚硅谷");
        System.out.println(returnValue);
    }
    //获取指定的方法
    @Test
    public void testStaticMethod() throws Exception {

        Class clazz = Student.class;

        //创建运行时类的对象
        Student student = (Student) clazz.newInstance();

        //获取指定的某个方法:getDeclaredMethod  参数1：指明要获取方法的名称，参数2：获取指定方法的形参列表，因为方法可能重载
        Method showHobby = clazz.getDeclaredMethod("showHobby");
        //保证当前属性是可访问的
        showHobby.setAccessible(true);
        //invoke(): 参数1：方法的调用者   参数2:给方法形参赋值的实参
        //invoke()方法的返回值，就是对应类中调用方法的返回值,如果没有返回值，则返回null
//        Object returnValue = showHobby.invoke(null);
        Object returnValue = showHobby.invoke(null);
        System.out.println(returnValue);
    }

    //获取指定的构造器
    @Test
    public void testConstructor() throws Exception {

        Class clazz = Student.class;
        //指明构造器的参数列表
        Constructor declaredConstructor = clazz.getDeclaredConstructor(String.class, String.class);

        //保证此构造器是可访问的
        declaredConstructor.setAccessible(true);
        //调用此构造器创建运行时类的对象
        Student student = (Student) declaredConstructor.newInstance("尚硅谷",  "北京中关村");
        System.out.println(student);
    }
}
