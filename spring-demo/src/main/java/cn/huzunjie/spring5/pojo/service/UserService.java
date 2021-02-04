package cn.huzunjie.spring5.pojo.service;

import cn.huzunjie.spring5.pojo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author HuZunJie
 * @Date 2021/2/4 15:24
 * @Email 826992656@qq.com
 * @Version 1.0
 */

@Service
public class UserService {
    @Value("abc")//@Value可以实现普通属性注入，把“abc”注入name属性
    private String name;
    //定义dao类型属性,@Autowired根据类型注入，@Qualifier根据名称注入
    //@Qualifier注解的使用，需要和@Autowired一起使用
//    @Autowired
//    @Qualifier(value="userDaoImpl1")

    //@Resource即可以根据类型注入，又可以根据名称注入
    //@Resource //根据类型注入
    @Resource(name = "userDaoImpl1")//根据名称注入
    private UserDao userDao;
    public void add(){
        System.out.println("service add ==========");
        userDao.add();
    }
}
