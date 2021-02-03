package cn.huzunjie.jdbc.mssql.demo.beans;

/**
 * @Author HuZunJie
 * @Date 2021/2/2 11:58
 * @Version 1.0
 */

public class Account {
    private int id;
    private String username;
    private String password;
    private String realname;

    public Account(String username, String password, String realname) {
        this.username = username;
        this.password = password;
        this.realname = realname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", realname='" + realname + '\'' +
                '}';
    }
}
