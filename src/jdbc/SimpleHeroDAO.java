package jdbc;

import charactor.SimpleHero;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SimpleHeroDAO implements DAO{

    public SimpleHeroDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                "root", "Qq199512");
    }

    public int getTotal() {
        int total = 0;
        try (Connection c = getConnection();
            Statement s = c.createStatement();) {

            String sql = "SELECT count(*) FROM hero;";
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()) {
                total = rs.getInt(1);
            }
            System.out.println("total: " + total);


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return total;
    }


    @Override
    public void add(SimpleHero hero) {
        String sql = "INSERT INTO hero (name, hp, damage) VALUES (?, ?, ?)";
        try(Connection c = getConnection();
            PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
            ps.setString(1, hero.name);
            ps.setFloat(2, hero.hp);
            ps.setInt(3, hero.damage);
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                hero.id = id;

                System.out.println("添加成功");
            }else{
                System.out.println("添加失败");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void delete(int id) {
        try (Connection c =getConnection();
             Statement s = c.createStatement();
            ) {

            String sql = "DELETE FROM hero WHERE id = " + id;
            s.execute(sql);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void update(SimpleHero hero) {
        String sql = "UPDATE hero SET name= ?, hp = ? , damage = ? WHERE id = ?";
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ) {

            ps.setString(1, hero.name);
            ps.setFloat(2, hero.hp);
            ps.setInt(3, hero.damage);
            ps.setInt(4, hero.id);

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                System.out.println("update success");
            } else {
                System.out.println("update fail.");
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    @Override
    public SimpleHero get(int id) {
        SimpleHero hero = null;

        try (Connection c = getConnection(); Statement s = c.createStatement();) {

            String sql = "SELECT * FROM hero WHERE id = " + id;

            ResultSet rs = s.executeQuery(sql);

            if (rs.next()) {
                hero = new SimpleHero();
                String name = rs.getString(2);
                float hp = rs.getFloat("hp");
                int damage = rs.getInt(4);
                hero.name = name;
                hero.hp = hp;
                hero.damage = damage;
                hero.id = id;
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return hero;
    }

    @Override
    public List<SimpleHero> list() {
        return list(0, Short.MAX_VALUE);
    }

    @Override
    public List<SimpleHero> list(int start, int count) {
        List<SimpleHero> heros = new ArrayList<SimpleHero>();

        String sql = "SELECT * FROM hero ORDER BY id DESC limit ?,? ";

        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setInt(1, start);
            ps.setInt(2, count);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                SimpleHero hero = new SimpleHero();
                int id = rs.getInt(1);
                String name = rs.getString(2);
                float hp = rs.getFloat("hp");
                int damage = rs.getInt(4);
                hero.id = id;
                hero.name = name;
                hero.hp = hp;
                hero.damage = damage;
                heros.add(hero);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return heros;
    }
}
