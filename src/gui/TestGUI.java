package gui;

import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class TestGUI {
    public static void main(String[] args) {
//        JFrame f = new JFrame("LOL");
//        f.setSize(400, 300);
//        f.setLocation(200, 200);
//        f.setLayout(null);
//        JButton b = new JButton("一键秒水晶");
//        b.setBounds(50, 50, 280, 30);
//
//        f.add(b);
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        f.setVisible(true);
        JDialog d = new JDialog();
        d.setTitle("LOL");
        d.setSize(400, 300);
        d.setLocation(200, 200);
        d.setLayout(null);

        JButton b = new JButton("一键秒水晶");
        b.setBounds(50, 50, 280, 30);
        d.add(b);
        d.setVisible(true);
    }
}
