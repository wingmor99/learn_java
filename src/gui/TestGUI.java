package gui;

import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class TestGUI {
    public static void main(String[] args) {
        JFrame f = new JFrame("外部窗体");
        f.setSize(800, 600);
        f.setLocation(100, 100);

        // 实例化JDialog
        JDialog d = new JDialog(f);
        //设置为模态
        d.setModal(true);

        d.setTitle("模态的对话框");
        d.setSize(400, 300);
        d.setLocation(200, 200);
        d.setLayout(null);
        JButton b = new JButton("一键秒基地");
        b.setBounds(50, 50, 280, 30);
        d.add(b);

        f.setVisible(true);
        d.setVisible(true);
    }
}
