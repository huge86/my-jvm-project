package cn.huzunjie.spring5.dao.impl;

import cn.huzunjie.spring5.dao.CustomerDao;

/**
 * @Author HuZunJie
 * @Date 2021/2/5 18:20
 * @Email 826992656@qq.com
 * @Version 1.0
 */

public  class CustomerDaoImpl implements CustomerDao {
    @Override
    public int add(int a, int b) {
        return a+b;
    }

    @Override
    public String update(String id) {
        return id;
    }
}
