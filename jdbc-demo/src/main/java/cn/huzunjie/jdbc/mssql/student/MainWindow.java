package cn.huzunjie.jdbc.mssql.student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * @Author HuZunJie
 * @Date 2021/2/2 9:56
 * @Version 1.0
 */

class MainWindow{
    //组件
    public JFrame sqlWindowFrame;
    public JPanel PanelSouth;
    public JPanel PanelNorth;
    public JTextArea textArea;
    public JScrollPane scrollPane;
    public JTextField inpuTextField;

    //一系列按钮
    public JButton customQueryBtn; //执行自定义sql代码的查询按钮
    public JButton noResultBtn; //执行没有返回值的sql代码的按钮 比如:create insert delete 这些
    public JButton createDBBtn; //创建数据库按钮
    public JButton createTBBtn; //创建数据表按钮
    public JButton insertBtn; //添加数据按钮
    public JButton showBtn; //展示5个学生数据的按钮
    public JButton updateBtn; //更新数据的按钮 男-5 女+3
    public JButton querySnoBtn; //通过学号查询的按钮
    public JLabel labelSouth; //底部标签
    public JLabel labelNorth; //顶部标签

    public SqlServer myServer; //把sqlServer作为内部类

    //窗口构造函数  主要用来初始化组件
    public void mainWindow() {
        // TODO Auto-generated constructor stub
        this.sqlWindowFrame = new JFrame("by fishers _(´ཀ`」 ∠)_"); //设置窗体 名字为notePad
        this.sqlWindowFrame.setLayout(new BorderLayout()); //边界布局方式
        this.sqlWindowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //设置关闭框
        this.sqlWindowFrame.setSize(800,500);

        this.textArea = new JTextArea();
        this.scrollPane = new JScrollPane(textArea);

        this.inpuTextField = new JTextField(30);
        this.customQueryBtn = new JButton("执行查询");
        this.noResultBtn = new JButton("执行无返回值的sql");
        this.createDBBtn = new JButton("创建数据库");
        this.createTBBtn = new JButton("创建数据表");
        this.insertBtn = new JButton("添加数据");
        this.showBtn = new JButton("展示数据");
        this.updateBtn = new JButton("更新数据");
        this.querySnoBtn = new JButton("查询学号");
        this.PanelSouth = new JPanel();
        this.PanelNorth = new JPanel();
        this.labelSouth = new JLabel("输入sql语法: ");
        this.labelNorth = new JLabel("内置功能区: ");
        this.myServer = new SqlServer();
        textArea.setFont(new Font("宋体",Font.PLAIN,20));
        textArea.setEditable(false); //设置文本域组件不可以编辑
        itemAdd();
        addListen();
    }

    //添加组件都写在这里
    public void itemAdd() {

        PanelSouth.add(labelSouth);
        PanelSouth.add(inpuTextField);
        PanelSouth.add(customQueryBtn);
        PanelSouth.add(noResultBtn);
        PanelSouth.add(noResultBtn);
        PanelNorth.add(labelNorth);
        PanelNorth.add(createDBBtn);
        PanelNorth.add(createTBBtn);
        PanelNorth.add(insertBtn);
        PanelNorth.add(showBtn);
        PanelNorth.add(updateBtn);
        PanelNorth.add(querySnoBtn);

        sqlWindowFrame.add(scrollPane,BorderLayout.CENTER);
        sqlWindowFrame.add(PanelSouth,BorderLayout.SOUTH);
        sqlWindowFrame.add(PanelNorth,BorderLayout.NORTH);
        sqlWindowFrame.setVisible(true);
    }

    //监听方法都写在这里
    public void addListen() {
        //监听自定义查询按钮
        customQueryBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String textString = inpuTextField.getText();
                System.out.println(textString);
                if(textString != null) {
                    try {
//						myServer.rsPrint(myServer.queryAll(textString));
                        String queryAns = myServer.returnString(myServer.queryAll(textString));
                        System.out.println(queryAns);
                        textArea.setText(queryAns);
                    } catch (SQLException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
            }
        });

        //监听没有返回值的按钮
        noResultBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String textString = inpuTextField.getText();
                System.out.println(textString);
                if(textString != null) {
                    try {
                        myServer.generalExc(textString);
                        textArea.setText("执行完成!");
                    } catch (SQLException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
            }
        });

        //监听创建数据库按钮
        createDBBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {
                    myServer.createDataBase("students");
                    textArea.setText("创建数据库完成!");
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    textArea.setText("创建数据库失败,请检查语法是否正确!或当前连接已经存在该数据库!");
                    e1.printStackTrace();
                }
            }
        });

        //监听创建数据表的按钮
        createTBBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {
                    myServer.createTable(myServer.createTableSql);
                    textArea.setText("创建数据表完成!");
                } catch (SQLException e1) {
                    textArea.setText("创建数据表失败,请检查语法是否正确!或当前数据库中已经存在该数据表!");
                    e1.printStackTrace();
                }
            }
        });

        //监听插入数据的按钮
        insertBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {
                    myServer.insertValue(myServer.insertSql);
                    textArea.setText("添加数据完成!");
                } catch (SQLException e1) {
                    textArea.setText("添加数据失败,请检查语法是否正确!或当前数据库中已经存在该数据!");
                    e1.printStackTrace();
                }
            }
        });

        //监听展示数据的按钮
        showBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {
                    String queryAns = myServer.returnString(myServer.queryAll(myServer.queryAllSql));
                    System.out.println(queryAns);
                    textArea.setText(queryAns);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        //监听更新数据的按钮
        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {
                    myServer.updateValue(myServer.updateBoySql);
                    myServer.updateValue(myServer.updateGrilSql);
                    textArea.setText("更新数据完成!");
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    textArea.setText("更新数据失败,请检查语法是否正确!");
                    e1.printStackTrace();
                }
            }
        });

        //监听通过学号查询数据的按钮
        querySnoBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {
                    int sno = Integer.valueOf(inpuTextField.getText());
                    String queryAns = myServer.returnString(myServer.queryBySno(sno));
//					if(queryAns == " " || queryAns == null) queryAns = "未查到该学生信息";
//					System.out.println(queryAns);
                    textArea.setText(queryAns);
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    textArea.setText("查询失败,请检查语法是否正确");
                    e1.printStackTrace();
                }
            }
        });
    }
}
