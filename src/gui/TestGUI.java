package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TestGUI {
    public static void main(String[] args) {

        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(580, 200);
        f.setLayout(null);

        final JLabel l = new JLabel();

        ImageIcon i = new ImageIcon("resource/shana.png");
        l.setIcon(i);
        l.setBounds(50, 50, i.getIconWidth(), i.getIconHeight());

        // 增加键盘监听
        f.addKeyListener(new KeyListener() {

            // 键被弹起
            @Override
            public void keyReleased(KeyEvent e) {

                // 39代表按下了 “右键”
                if (e.getKeyChar() == 'd') {
                    // 图片向右移动 （y坐标不变，x坐标增加）
                    l.setLocation(l.getX() + 50, l.getY());
                }
                System.out.println(e.getKeyChar());
            }

            //键被按下
            @Override
            public void keyPressed(KeyEvent e) {
                // TODO Auto-generated method stub

            }

            // 一个按下弹起的组合动作
            @Override
            public void keyTyped(KeyEvent e) {

            }
        });

        f.add(l);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setVisible(true);
    }
}
