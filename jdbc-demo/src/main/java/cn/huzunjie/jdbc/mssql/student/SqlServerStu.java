package cn.huzunjie.jdbc.mssql.student;

import java.sql.*;

/**
 * @Author HuZunJie
 * @Date 2021/2/2 9:37
 * @Version 1.0
 */



//主进程启动
public class SqlServerStu {
    public static void main(String []args) throws SQLException {
        SqlServer myServer = new SqlServer();
        myServer.createTable(myServer.createTableSql); //创建数据表
        myServer.close();

//		String urlParam = "jdbc:sqlserver://127.0.0.1:1433?user=sa&password=root"; //这个连接url好像不能用啊
//		sqlServer myServer = new sqlServer();
//		myServer.createDataBase("students"); //创建数据库
//		myServer.createTable(myServer.createTableSql); //创建数据表
//		myServer.insertValue(myServer.insertSql); //增
//		myServer.rsPrint(myServer.queryAll(myServer.queryAllSql)); //查
//		myServer.rsPrint(myServer.queryBySno(2)); //查
//		myServer.updateValue(myServer.updateBoySql); //改
//		myServer.delById(1); //删
//		myServer.rsPrint(myServer.queryAll(myServer.queryAllSql)); //查
//		myServer.delDataBase("students"); //删
//		myServer.close(); //关闭连接
//		myServer.inputSnoAndQuery();
//		myServer.updateValue(myServer.updateBoySql);
//		myServer.delDataBase("students");
//		myServer.createDataBase("qwertest12");
//        window myWindow = new window(); //最后还是做成了窗口 orz
    }
}
