package jdbc;

import charactor.SimpleHero;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public static SimpleHero get(int id) {
        SimpleHero hero = null;
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
            String sql = "SELECT * FROM hero WHERE id = " + id;
            ResultSet rs = s.executeQuery(sql);

            // id 唯一
            if (rs.next()){
                hero = new SimpleHero();
                String name = rs.getString(2);
                float hp = rs.getFloat("hp");
                int damage = rs.getInt(4);
                hero.name = name;
                hero.hp = hp;
                hero.damage = damage;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return hero;
    }

    public static void add(SimpleHero h) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "INSERT INTO hero (name, hp, damage) VALUES (?, ?, ?)";
        try (Connection c = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                "root", "Qq199512");
             Statement s = c.createStatement();
             PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ){
            ps.setString(1, h.name);
            ps.setFloat(2, h.hp);
            ps.setInt(3, h.damage);
            ps.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void delete(SimpleHero h) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "DELETE FROM hero WHERE name = ? AND hp = ? AND damage = ?;";
        try (Connection c = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                "root", "Qq199512");
             Statement s = c.createStatement();
             PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ){
            ps.setString(1, h.name);
            ps.setFloat(2, h.hp);
            ps.setInt(3, h.damage);
            ps.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void update(SimpleHero h) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "UPDATE hero SET name = ?, hp = ?, damage = ? WHERE id = ?";
        try (Connection c = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                "root", "Qq199512");
             Statement s = c.createStatement();
             PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ){
            c.setAutoCommit(false);
            ps.setInt(4, h.id);
            ps.setString(1, h.name);
            ps.setFloat(2, h.hp);
            ps.setInt(3, h.damage);
            ps.execute();
            int b1 = ps.executeUpdate();
            c.commit();
            if (b1 == 0) {
                System.out.println("未找到该条数据");
            } else {
                System.out.println("修改成功");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static List<SimpleHero> list() {
        List<SimpleHero> list = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection c = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                "root", "Qq199512");
             Statement s = c.createStatement();
        ){
            String sql = "SELECT * FROM hero;";
            c.setAutoCommit(false);
            s.executeQuery(sql);
            ResultSet rs = s.getResultSet();
            while(rs.next()) {
                SimpleHero h = new SimpleHero();
                h.id = rs.getInt("id");
                h.name = rs.getString("name");
                h.hp = rs.getFloat("hp");
                h.damage = rs.getInt("damage");
                list.add(h);
            }
            c.commit();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }


    public static void main(String[] args) {
        SimpleHero h = get(5);
        System.out.println(h.name);

        SimpleHero im = new SimpleHero("铁男", 600.0f, 45);
//        add(im);
//        delete(im);
//        im.name = "IronMan";
//        im.id = 16;
//        update(im);

        List<SimpleHero> heroList = list();
        System.out.println(heroList);
    }
}
