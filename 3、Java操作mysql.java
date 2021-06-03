package com.company;

import java.sql.*;

public class 操作mysql {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/news";

    static final String USER = "root";
    static final String PASS = "toor";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName(JDBC_DRIVER);

            System.out.println("连接数据库……");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            System.out.println("实例化Statement对象……");
            stmt = conn.createStatement();
            String sql;
            sql = "select * from ithomenews";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()){
                int id = rs.getInt("id");
                String title = rs.getString("title");
                Date puttime = rs.getDate("puttime");

                System.out.println("id:"+id+",title:"+title+",puttime:"+puttime);
            }
            rs.close();
            stmt.close();
            conn.close();
        }catch (SQLException se){
            se.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (stmt != null) stmt.close();
            }catch (SQLException se2){
            }
            try {
                if (conn != null) conn.close();
            }catch (SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("goodbye");
    }
}
