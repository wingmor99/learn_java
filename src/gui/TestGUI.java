package gui;

import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class TestGUI {
    public static void main(String[] args) {
        JFrame f = new JFrame("外部窗体");
        f.setSize(800, 600);
        f.setLocation(100, 100);
        f.setLayout(null);
        JButton b = new JButton("一键秒基地");
        b.setBounds(50, 50, 280, 30);
        f.add(b);

        //窗体大小不可变
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setVisible(true);
    }
}
