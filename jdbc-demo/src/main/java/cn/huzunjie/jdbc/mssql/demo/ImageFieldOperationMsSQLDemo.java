package cn.huzunjie.jdbc.mssql.demo;

/**
 * @Author HuZunJie
 * @Date 2021/2/2 15:11
 * @Version 1.0
 */


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class ImageFieldOperationMsSQLDemo {
    public Connection getCon(){
        try{
            //连接SQLServer2016
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=test","sa","123456");
            return con;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args){
        try{
            ImageFieldOperationMsSQLDemo t = new ImageFieldOperationMsSQLDemo();
            //t.writeFileToDb("D:\\pic\\from\\pic1.jpg");
            t.readImgFromDb("D:\\pic\\from\\pic1.jpg","D:\\pic\\to\\pic1FromDB.jpg");
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


    public void readImgFromDb(String picName,String newName){
        System.out.println("Reading from database to file:"+newName);
        Connection con = null;
        try{
            con = getCon();
            OutputStream out = new FileOutputStream(newName);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from pic where picname='"+picName+"'");
            if(rs.next()){
                System.out.println(rs.getString("picname"));
                int tmpi=0;
                InputStream  ins= rs.getBinaryStream("picdata");
                while((tmpi=ins.read())!=-1){
                    out.write(tmpi);
                }
                ins.close();
                out.flush();
                out.close();
                System.out.println("Reading from database to file "+newName+" success");
            }
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
            con = null;
        }
    }
}