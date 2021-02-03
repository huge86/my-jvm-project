package cn.huzunjie.spring5.service;

import cn.huzunjie.spring5.dao.UserDao;
import cn.huzunjie.spring5.dao.impl.UserDaoImpl;

/**
 * @Author HuZunJie
 * @Date 2021/2/3 17:13
 * @Email 826992656@qq.com
 * @Version 1.0
 */

public class UserService {
    //创建UserDao类型属性，生成set方法
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add(){
        System.out.println("UserService中的add方法，执行了---");
        //方法一：传统方式
        //创建UserDao对象
        UserDao userDao = new UserDaoImpl();
        userDao.update();
    }

    public  void update(){

        userDao.update();
    }
}
