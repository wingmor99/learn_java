package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestGUI {
    public static void main(String[] args) {
        JFrame f = new JFrame("LOL");
        f.setSize(400, 300);
        f.setLocation(580, 200);
        f.setLayout(null);

        final JLabel l = new JLabel();
        ImageIcon i = new ImageIcon("resource/shana.png");
        l.setIcon(i);
        l.setBounds(50, 50, i.getIconWidth(), i.getIconHeight());

        JButton b = new JButton("隐藏图片");
        b.setBounds(150, 200, 100, 30);
        // 按键增加监听
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                l.setVisible(false);
            }
        });

        f.add(l);
        f.add(b);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
