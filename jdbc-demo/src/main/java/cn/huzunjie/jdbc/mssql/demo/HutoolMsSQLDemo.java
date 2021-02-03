package cn.huzunjie.jdbc.mssql.demo;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import cn.hutool.db.Page;
import cn.hutool.db.PageResult;
import cn.hutool.db.sql.Condition;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author HuZunJie
 * @Date 2021/2/2 11:07
 * @Version 1.0
 */

public class HutoolMsSQLDemo {
//增
//  Hutool底层的DSFactory默认调用resources目录下db.setting配置
    @Test
   public void insertTest() throws SQLException {
       Db.use().insert(
               Entity.create("user")
                       .set("name", "unitTestUser")
                       .set("age", 66)
       );
   }

   @Test
   public void returnGeneratedKeyAfterinsert() throws SQLException {
        //出入数据后，返回自增主键
       Long primaryKey = Db.use().insertForGeneratedKey(
               Entity.create("account")
                       .set("username", "徐龙象")
                       .set("password", "666666")
                       .set("realname", "徐蛮子")
       );
       System.out.println("primaryKey="+primaryKey);
   }

   //删
@Test
    public void deleteTest() throws SQLException {
        Db.use().del(
                Entity.create("account").set("id", 3)//where条件
        );
    }
    //改
@Test
    public void updateTest() throws SQLException{
        Db.use().update(
                Entity.create().set("password", "654321"), //修改的数据
                Entity.create("account").set("id", 2) //where条件
        );
    }
    //查
   @Test
   public void findAllQueryTest() throws SQLException {
//       user为表名,查询所有字段
        List<Entity> list = Db.use().findAll("user");
        for (Entity entity : list) {
            System.out.println(entity.toString());
        }
   }

    @Test
    public void findAllByConditionsQueryTest() throws SQLException {
//       account为表名,条件查询
        List<Entity> list = Db.use().findAll(
                Entity.create("account").set("username", "徐龙象")
        );
        for (Entity entity : list) {
            System.out.println(entity.toString());
        }
    }

    @Test
    public void findLikeQueryTest() throws SQLException {
//       account为表名,模糊查询
        List<Entity> list = Db.use().findLike("account", "username", "徐%", Condition.LikeType.Contains);
        for (Entity entity : list) {
            System.out.println(entity.toString());
        }
    }

    @Test
    public void pageQueryTest() throws SQLException {
//       user为表名,分页查询
        //Page对象通过传入页码和每页条目数达到分页目的,页码从0开始
        PageResult<Entity> result = Db.use().page(Entity.create("user").set("age", "> 20"), new Page(0, 3));
        for (Entity entity : result) {
            System.out.println(entity.toString());
        }
    }

    @Test
    public void queryBySql() throws SQLException {
//        直接sql语句操作:查询数据 query
        List<Entity> list = Db.use().query("select * from user where age < ?", 50);
        for (Entity entity : list) {
            System.out.println(entity.toString());
        }
    }


   @Test
   public void updateBySql() throws SQLException {
//        直接sql语句操作:更新数据  insert/update/delete
       Integer i = Db.use().execute("insert into account (username,password,realname) values(?,?,?)", "zhangxiao", "1234568", "张晓");
        if (i > 0) {
            System.out.println("数据插入成功");
        } else {
            System.out.println("数据插入失败");
        }
   }


   @Test
   public void txTest(){
//       Db.use().tx(
//               new TxFunc() {
//                   public void call(Db db) throws SQLException {
//                       db.insert(Entity.create("user").set("name", "unitTestUser"));
//                       db.update(Entity.create().set("age", 79), Entity.create("user").set("name", "unitTestUser"));
//                   }
//               }
//       );
   }

}
