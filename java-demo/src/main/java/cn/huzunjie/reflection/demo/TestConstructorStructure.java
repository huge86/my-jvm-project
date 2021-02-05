package cn.huzunjie.reflection.demo;

import cn.huzunjie.reflection.beans.Person;
import cn.huzunjie.reflection.beans.Student;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @Author HuZunJie
 * @Date 2021/2/5 8:52
 * @Email 826992656@qq.com
 * @Version 1.0
 */

public class TestConstructorStructure {
//    获取构造器结构
    @Test
    public void test1(){
        /*
        * 返回结果示例：clazz.getConstructors获取当前运行时类中声明为public的构造器
        * public cn.huzunjie.reflection.beans.Person(int)
          public cn.huzunjie.reflection.beans.Person(java.lang.String,int)
        * */

        Class clazz = Person.class;
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
    }

    @Test
    public void test2(){
        /*
        * 返回结果示例：clazz.getDeclaredConstructors获取当前运行时类中声明的所有构造器
        * private cn.huzunjie.reflection.beans.Person(java.lang.String)
            public cn.huzunjie.reflection.beans.Person(int)
            public cn.huzunjie.reflection.beans.Person(java.lang.String,int)
        * */

        Class clazz = Person.class;
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
    }
    @Test
    public void test3() {
        /*
        * 获取运行时类的父类：clazz.getSuperclass
          返回结果示例：  class java.lang.Object
        * */
        Class clazz = Student.class;
        Class superclass = clazz.getSuperclass();
        System.out.println(superclass);
    }
    @Test
    public void test4() {
        /*
        * 获取运行时类的带泛型的父类：clazz.getGenericSuperclass()
          返回结果示例：
        * */
        Class clazz = Student.class;
        Type genericSuperclass = clazz.getGenericSuperclass();
        System.out.println(genericSuperclass);
    }
    @Test
    public void test5() {
        /*
        * 获取运行时类的带泛型的父类的泛型：clazz.getGenericSuperclass()
          返回结果示例：
        * */
        Class clazz = Student.class;
        Type genericSuperclass = clazz.getGenericSuperclass();
//        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        //获取泛型类型
//        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();

        //System.out.println(actualTypeArguments[0].getTypeName());
//        for (Type actualTypeArgument : actualTypeArguments) {
//            System.out.println(actualTypeArgument);
//        }
        System.out.println(genericSuperclass);

    }

    @Test
    public void test6() {
        /*
        * 获取运行时类实现的接口
          返回结果示例：
        * */
        Class clazz = Student.class;
        Class[] interfaces = clazz.getInterfaces();
        for (Class anInterface : interfaces) {
            System.out.println(anInterface);
        }
        //获取运行时类父类的接口
        Class[] interfaces1 = clazz.getSuperclass().getInterfaces();
        for (Class aClass : interfaces1) {
            System.out.println(aClass);
        }
    }

    @Test
    public void test7() {
        /*
        * 获取运行时类所在的包
          返回结果示例：
        * */
        Class clazz = Student.class;
        Package aPackage = clazz.getPackage();
        System.out.println(aPackage);
    }
    @Test
    public void test8() {
        /*
        * 获取运行时类声明的注解
          返回结果示例：
        * */
        Class clazz = Student.class;
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }
}
