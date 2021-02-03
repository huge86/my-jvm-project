package cn.huzunjie.jdbc.mssql.student;

import java.sql.*;
import java.util.Scanner;

/**
 * @Author HuZunJie
 * @Date 2021/2/2 9:52
 * @Version 1.0
 */

public class SqlServer {
    private Connection connection = null; //连接接口实例
    private Statement statmment = null; //执行静态sql的接口实例
    private PreparedStatement preStatement = null; //执行动态sql的接口实例
    private ResultSet resSet = null; // sql查询的返回数据集合
//    生产环境
//    String dbName = "USER00012019"; //数据库名
//    String tbName = "z_fjdata"; //数据表名 没必要其实
//    String url = "jdbc:sqlserver://103.89.185.118:51545"; //sqlserver连接地址url
//    String userName = "test";  //sqlserver的账号名 要在SMSS安全性里面设置
//    String passWord = ""; //sqlserver的账号的密码 要在SMSS安全性里面设置

//    本地测试环境
    String dbName = "students"; //数据库名
    String tbName = ""; //数据表名 没必要其实
    String url = "jdbc:sqlserver://127.0.0.1:1433"; //sqlserver连接地址url
    String userName = "sa";  //sqlserver的账号名 要在SMSS安全性里面设置
    String passWord = "123456"; //sqlserver的账号的密码 要在SMSS安全性里面设置

    //下面就是按课题要求写的一些静态代码(String字符串类型,在SqlCode.java文件中的全局变量)
    String createTableSql = SqlCode.createTable;
    String insertSql = SqlCode.insertValues;
    String queryAllSql = SqlCode.queryString;
    String updateBoySql = SqlCode.updateScoreBoy;
    String updateGrilSql = SqlCode.updateScoreGirl;
    String delByIdSql = SqlCode.deleteByIdSql;

    //无参构造函数 初始化建立连接
    public void sqlServer() {
        // TODO Auto-generated constructor stub
        System.out.println("无参构造方法执行了===");
        try {
            //加载数据库驱动
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //DriverManager接口获取连接
            this.connection = DriverManager.getConnection(url,userName,passWord);
            //获取 执行数据库静态SQL语法的接口
            this.statmment = connection.createStatement();
            if(connection != null) {
                System.out.println("连接成功!");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //有参构造函数 urlParam初始化建立连接
    public void sqlServer(String urlParam) {
        // TODO Auto-generated constructor stub
        System.out.println("有参构造方法执行了---");
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            this.connection = DriverManager.getConnection(urlParam);
            this.statmment = connection.createStatement();
            if(connection != null) {
                System.out.println("连接成功!");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //关闭连接
    public void close() throws SQLException {
        if(resSet != null) {
            resSet.close();
        }
        if(statmment != null) {
            statmment.close();
        }
        if(preStatement != null) {
            preStatement.close();
        }
        if(connection != null) {
            System.out.println("关闭连接!");
            connection.close();
        }
    }

    //打印输出 ResultSet集合中的数据
    public void rsPrint(ResultSet rS) throws SQLException {
        if(rS == null) return;
        System.out.println("");
        System.out.println("sno"+"|   name"+"   | ssex"+"  | score");
        while(rS.next()) {
            int sno = rS.getInt("sno");
            String name = rS.getString("name");
            String ssex = rS.getString("ssex");
            int score = rS.getInt("score");
            System.out.println(sno+"  |  "+name+"  |  "+ssex+"  |  "+score);
        }
    }

    //返回ResultSet集合
    public ResultSet queryBySno(int snoId) throws SQLException {
        String queryByIdString = ""
                + "USE students"
                + "\n"
                + "SELECT * FROM scores"
                + "\n"
                + "WHERE scores.sno = ?"
                + "";
        this.preStatement = connection.prepareStatement(queryByIdString);
        preStatement.setInt(1, snoId);
        return preStatement.executeQuery();
    }

    //查询全部
    public ResultSet queryAll(String querySql) throws SQLException {
        return statmment.executeQuery(querySql);
    }

    //创建数据库
    public void generalExc(String sql) throws SQLException {
        preStatement = connection.prepareStatement(sql);
        preStatement.executeUpdate();
    }

    //创建数据库
    public void createDataBase(String dbName) throws SQLException {
        String createSql = "CREATE DATABASE "+dbName;
        preStatement = connection.prepareStatement(createSql);
//		preStatement.setString(1, dbName);
        preStatement.executeUpdate();
        System.out.println("创建数据库"+dbName+"成功!");
    }

    //删除数据库
    public void delDataBase(String dbName) throws SQLException {
        String deleteSql = "DROP DATABASE "+dbName;
        preStatement = connection.prepareStatement(deleteSql);
//		preStatement.setString(1, dbName);
        preStatement.executeUpdate();
        System.out.println("删除数据库"+dbName+"成功!");
    }

    //通过sno学号删除 数据表中的记录
    public void delById(int sno) throws SQLException {
        preStatement = connection.prepareStatement(delByIdSql + sno);
        preStatement.executeUpdate();
        System.out.println("删除记录"+"成功!");
    }

    //创建数据表
    public void createTable(String createSql) throws SQLException {
        statmment.execute(createSql);
        System.out.println("创建数据表"+"成功!");
    }

    //插入数据到数据表
    public void insertValue(String insertSql) throws SQLException {
        statmment.execute(insertSql);
        System.out.println("插入数据"+"成功!");
    }

    //更新数据表中的数据
    public void updateValue(String updateSql) throws SQLException {
        statmment.execute(updateSql);
        System.out.println("更新完成!");
    }

    //scanner输入指定学号,查询学生信息
    public void inputSnoAndQuery() throws SQLException {
        Scanner inputScanner = new Scanner(System.in);
        int snoId = inputScanner.nextInt();
        rsPrint(queryBySno(snoId));
    }

    //返回值:把ResultSet集合中的数据转换成String类型  (因为后面展示到窗口文本域需要string类型)
    public String returnString(ResultSet rS) throws SQLException {
        // TODO Auto-generated method stub
        StringBuffer myBuffer = new StringBuffer();
        int line = 0;
        while(rS.next()) {
            if(line == 0) {
                line++;
                myBuffer.append("查询结果如下: "+"\n");
//				myBuffer.append("sno"+"|   name"+"   | ssex"+"  | score"+"\n");
            }
            int sno = rS.getInt("sno");
            String name = rS.getString("name");
            String ssex = rS.getString("ssex");
            int score = rS.getInt("score");
            myBuffer.append(sno+"  |  "+name+"  |  "+ssex+"  |  "+score+"\n");
        }
        if(line == 0) myBuffer.append("");
        return myBuffer.toString();
    }

}
