package gui;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.util.Random;

public class TestGUI {
    public static void main(String[] args) {
        JFrame f = new JFrame("外部窗体");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        // 绝对定位，所有组件都要指定位置和大小
        f.setLayout(null);

        // 设置布局器为FlowLayerout
        // 容器上的组件水平摆放
        f.setLayout(new FlowLayout());

        JButton b1 = new JButton("英雄1");
        JButton b2 = new JButton("英雄2");
        JButton b3 = new JButton("英雄3");

        // 加入到容器即可，无需单独指定大小和位置
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setVisible(true);
    }
}
