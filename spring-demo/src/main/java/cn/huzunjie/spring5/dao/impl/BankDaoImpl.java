package cn.huzunjie.spring5.dao.impl;

import cn.huzunjie.spring5.dao.BankDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @Author HuZunJie
 * @Date 2021/2/6 16:04
 * @Email 826992656@qq.com
 * @Version 1.0
 */

@Repository
public class BankDaoImpl implements cn.huzunjie.spring5.dao.BankDao {
    //注入JdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //多钱
    @Override
    public void addMoney() {

        //lucy转账100给mary
        String sql = "update t_account set money=money+? where username=?";
        jdbcTemplate.update(sql, 100,"mary");
    }

    //少钱
    @Override
    public void reduceMoney() {
        //lucy转账100给mary
        String sql = "update t_account set money=money-? where username=?";
        jdbcTemplate.update(sql, 100,"lucy");

    }
}
