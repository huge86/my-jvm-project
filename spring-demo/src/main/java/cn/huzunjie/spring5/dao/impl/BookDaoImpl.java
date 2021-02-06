package cn.huzunjie.spring5.dao.impl;

import cn.huzunjie.spring5.beans.Book;
import cn.huzunjie.spring5.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

/**
 * @Author HuZunJie
 * @Date 2021/2/6 11:18
 * @Email 826992656@qq.com
 * @Version 1.0
 */

@Repository
public  class BookDaoImpl implements BookDao {
//    注入JdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void add(Book book) {
        /*
        * 1、创建SQL语句*/
        String sql = "insert into books (id,name,author) values (?,?,?)";
        //2、调用方法实现
        int update = jdbcTemplate.update(sql, book.getId(), book.getName(), book.getAuthor());
        System.out.println(update);
    }
//修改
    @Override
    public void updateBook(Book book) {
        String sql = "update books set name = ?, author = ? where id = ?";
        int update = jdbcTemplate.update(sql, book.getName(), book.getAuthor(), book.getId());
        System.out.println(update);
    }
//删除
    @Override
    public void delete(String id) {
        String sql = "delete from books where id = ?";
        int update = jdbcTemplate.update(sql, id);
        System.out.println(update);

    }
//查询表记录数
    @Override
    public int selectCount() {
        String sql = "select count(*) from books";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count;
    }
    //查询返回对象
    @Override
    public Book findBookInfo(String id) {
        String sql = "select * from books where id = ?";
//        调用JdbcTemplate方法
//        三个参数：第一个参数：sql语句；
//        第二个参数：RowMaper，是接口，返回不同类型数据，使用这个接口里面的实现类完成数据的封装
//        第三个参数：？的替换值
        Book book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Book.class), id);
        return book;
    }

    //查询返回集合
    @Override
    public List<Book> findAllBook() {
        String sql = "select * from books";
        //        调用JdbcTemplate方法
        List<Book> bookList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Book.class));
        return bookList;
    }
    //批量添加
    @Override
    public void batchAddBook(List<Object[]> batchArgs) {
        String sql = "insert into books values(?,?,?)";
        //        调用JdbcTemplate方法
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(ints));
    }

    //批量修改
    @Override
    public void batchUpdateBook(List<Object[]> batchArgs) {

        String sql = "update books set name = ?, author = ? where id = ?";
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(ints));
    }

    //批量删除
    @Override
    public void batchDeleteBook(List<Object[]> batchArgs) {
        String sql = "delete from books where id = ?";
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(ints));
    }
}

