package cn.huzunjie.pingpu;

/**
 * @Author HuZunJie
 * @Date 2021/2/2 14:15
 * @Version 1.0
 */

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.*;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class App {
    private static String endpoint = "oss-cn-beijing.aliyuncs.com";
    private static String accessKeyId = "LTAI4G9Hz36UcHQz7ZnkgupP";
    private static String accessKeySecret = "1";
    private static String bucketName = "20210201";
    private static String objectKey = "";

    private static OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);


    public Connection getCon(){
        try{
            //连接SQLServer2016
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://103.89.185.118:51545;DatabaseName=USER00012019","test","");
            return con;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args){
        if (ossClient.doesBucketExist(bucketName)) {
            System.out.println("您已经创建Bucket：" + bucketName + "。");
        } else {
            System.out.println("您的Bucket不存在，创建Bucket：" + bucketName + "。");
            ossClient.createBucket(bucketName);
        }

        try{
            App t = new App();
            t.msSqlToOss();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public void writeFileToDb(String fileName){
        System.out.println("Writing to database... from file:"+fileName);
        Connection con = null;
        try{
            con = getCon();
            File myFile = new File(fileName);
            InputStream in = new FileInputStream(myFile);
            String sql = "insert into pic (picname,picdata) values(?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,fileName);
            ps.setBinaryStream(2,in,(int)myFile.length());
            int result = ps.executeUpdate();
            if (result>0)
                System.out.println("Writing picfile to database  success");
            else
                System.out.println("Writing picfile to database  error");
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            if (con !=null){
                try{
                    con.close();
                }catch(Exception ex){
                    ex.printStackTrace();
                }
                con = null;
            }
        }
    }


    public void msSqlToOss(){

        Connection con = null;

        try{
            con = getCon();
            InputStream  ins= null;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select top 10 * from z_fjdata");
            while (rs.next()){
                String fname = rs.getString("fname");
                ins= rs.getBinaryStream("fdata");
                System.out.println(fname);
                //writeFileToOss(ins,fname);
                ossClient.putObject(bucketName, fname, ins);

            }
            ins.close();

        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            if (con!=null){
                try{
                    con.close();
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
            ossClient.shutdown();
            con = null;

        }
    }

//    public void writeFileToOss(InputStream  ins, String key){
//
//        int tmpi=0;
//        Long firstPosition = 0L;
//        AppendObjectResult appendObjectResult = ossClient.appendObject(
//                new AppendObjectRequest(bucketName, key, ins).withPosition(firstPosition));
//
//        try {
//            Long nextPosition = appendObjectResult.getNextPosition();
//            ossClient.putObject(bucketName, key, ins);
//            while((tmpi=ins.read())!=-1){
//
//                appendObjectResult = ossClient.appendObject(
//                        new AppendObjectRequest(bucketName, key, ins)
//                                .withPosition(nextPosition));
//
//
//            }
//
//        } catch (OSSException oe) {
//            oe.printStackTrace();
//        } catch (ClientException ce) {
//            ce.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}