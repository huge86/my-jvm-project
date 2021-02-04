package cn.huzunjie.spring5.beans;

import org.springframework.beans.factory.FactoryBean;

/**
 * @Author HuZunJie
 * @Date 2021/2/4 9:45
 * @Email 826992656@qq.com
 * @Version 1.0
 */

public class MyBean implements FactoryBean<Course> {
    @Override
    public Course getObject() throws Exception {
        Course course = new Course();
        course.setCname("Java编程思想");
        return course;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
