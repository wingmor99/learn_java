package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class TestGUI {
    public static void main(String[] args) {
        JFrame f = new JFrame("外部窗体");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        // 绝对定位，所有组件都要指定位置和大小
        f.setLayout(null);

        // 设置布局器为GridLayerout，即网格布局器
        // 该GridLayerout的构造方法表示该网格是2行3列
        f.setLayout(new GridLayout(2, 3));

        JButton b1 = new JButton("洪七");
        JButton b2 = new JButton("段智兴");
        JButton b3 = new JButton("欧阳锋");
        JButton b4 = new JButton("黄药师");
        JButton b5 = new JButton("周伯通");

        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.add(b5);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
