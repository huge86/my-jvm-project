package cn.huzunjie.jdbc.mssql.student;

/**
 * @Author HuZunJie
 * @Date 2021/2/2 9:43
 * @Version 1.0
 */


/*
 * 这里放的是 静态Sql代码
 */

public class SqlCode {

    // 在数据students中创建表scores
    static String createTable = ""
            + "USE students;"
            + "\n"
            + "CREATE TABLE scores"
            + "("
            + "sno int not null,"
            + "name varchar(20) not null,"
            + "ssex varchar(10) CHECK(ssex IN('boy','girl')),"
            + "score int not null,"
            + "PRIMARY KEY(sno),"
            + ")";

    //在表格scores插入5条记录
    static String insertValues = ""
            + "USE students"
            + "\n"
            + "INSERT INTO scores(sno,name,ssex,score) VALUES(1,'DaWang','boy','61')"
            + "\n"
            + "INSERT INTO scores(sno,name,ssex,score) VALUES(2,'ErWang','girl','62')"
            + "\n"
            + "INSERT INTO scores(sno,name,ssex,score) VALUES(3,'SanWang','boy','63')"
            + "\n"
            + "INSERT INTO scores(sno,name,ssex,score) VALUES(4,'siWang','girl','65')"
            + "\n"
            + "INSERT INTO scores(sno,name,ssex,score) VALUES(5,'wuWang','girl','66')";

    //显示5位学生的所有信息
    static String queryString = ""
            + "USE students"
            + "\n"
            + "SELECT TOP 5 * FROM scores";

    //将三位男生的得分减去5 tucao:男生真累
    static String updateScoreBoy = ""
            + "USE students"
            + "\n"
            + "UPDATE scores "
            + "\n"
            + "SET score = score - 5"
            + "\n"
            + "WHERE ssex = 'boy'"
            + "\n";

    //将两位女生的成绩加上3分
    static String updateScoreGirl = ""
            + "USE students"
            + "\n"
            + "UPDATE scores "
            + "\n"
            + "SET score = score + 3"
            + "\n"
            + "WHERE ssex = 'girl'"
            + "\n";

    //删除某个学号 自己测试数据用的
    static String deleteByIdSql = "USE students"
            + "\n"
            + "DELETE FROM scores WHERE sno = ";
}

