package gui;

import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class TestGUI {
    public static void main(String[] args) {
        JFrame f = new JFrame("外部窗体");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        // 绝对定位，所有组件都要指定位置和大小
        f.setLayout(null);
        // 指定位置和大小
        JButton b1 = new JButton("英雄1");
        b1.setBounds(50, 50, 80, 30);
        JButton b2 = new JButton("英雄2");
        b2.setBounds(150, 50, 80, 30);
        JButton b3 = new JButton("英雄3");
        b3.setBounds(250, 50, 80, 30);
        // 没有指定位置和大小，不会出现在容器上
        JButton b4 = new JButton("英雄3");

        f.add(b1);
        f.add(b2);
        f.add(b3);
        // b4没有指定位置和大小，不会出现在容器上
        f.add(b4);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setVisible(true);
    }
}
