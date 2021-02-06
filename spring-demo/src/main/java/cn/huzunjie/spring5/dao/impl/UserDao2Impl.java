package cn.huzunjie.spring5.dao.impl;

import cn.huzunjie.spring5.dao.UserDao2;
import org.springframework.stereotype.Repository;

/**
 * @Author HuZunJie
 * @Date 2021/2/4 15:21
 * @Email 826992656@qq.com
 * @Version 1.0
 */

@Repository(value="userDaoImpl1")
public class UserDao2Impl implements UserDao2 {
    @Override
    public void add() {
        System.out.println("dao add-----");

    }
}
