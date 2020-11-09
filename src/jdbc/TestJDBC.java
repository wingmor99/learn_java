package jdbc;

import java.sql.*;

public class TestJDBC {
    public static void execute(String sqlStatement) {
        Connection c = null;
        Statement s = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 建立与数据库的Connection连接
            // 这里需要提供：
            // 数据库所处于的ip:127.0.0.1 (本机)
            // 数据库的端口号： 3306 （mysql专用端口号）
            // 数据库名称 how2java
            // 编码方式 UTF-8
            // 账号 root
            // 密码 admin

            c = DriverManager
                    .getConnection(
                            "jdbc:mysql://localhost:3306/how2java?characterEncoding=UTF-8",
                            "root", "Qq199512");

            System.out.println("连接成功，获取连接对象： " + c);
            s = c.createStatement();

            // sql 语句
//            String sql = "insert into hero values(2,"+"'提莫'"+","+313.0f+","+50+")";
            String sql = sqlStatement;
            s.execute(sql);
            System.out.println("执行插入语句成功");

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            // 数据库的连接时有限资源，相关操作结束后，养成关闭数据库的好习惯
            // 先关闭Statement
            if (s != null) {
                try {
                    s.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            // 后关闭Connection
            if (c != null) {
                try {
                    c.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

    }


    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection c = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                "root", "Qq199512");
             Statement s = c.createStatement();
             ) {
            /**
             * 事务，要么都运行，要么都不运行
             */
            c.setAutoCommit(false);

            // 加血
            String sqlAdd = "UPDATE hero SET hp = hp + 1 WHERE id = 1;";
            String sqlDec = "UPDATE hero SET hp = hp - 1 WHERE id = 1;";
            s.execute(sqlAdd);
            s.execute(sqlDec);

            c.commit();
            }
         catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
