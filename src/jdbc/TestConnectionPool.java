package jdbc;

import multiplethread.ThreadPool;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnectionPool {
    public static void main(String[] args) {
        ConnectionPool cp = new ConnectionPool(3);
        for (int i = 0; i < 10; i++) {
            new WorkingThread("woring thread " + i, cp).start();
        }


    }
}

class WorkingThread extends Thread {
    private ConnectionPool cp;

    public WorkingThread(String name, ConnectionPool cp) {
        super(name);
        this.cp=cp;
    }

    @Override
    public void run() {
        Connection c = cp.getConnection();
        System.out.println(this.getName() + ":\t 获取了一根连接， 开始工作");
        try (Statement s = c.createStatement()) {
            // 模拟耗时一秒的sql语句
            Thread.sleep(1000);
            s.execute("SELECT * FROM hero;");
        } catch (SQLException | InterruptedException throwables) {
            throwables.printStackTrace();
        }
        cp.returnConnection(c);
    }
}
