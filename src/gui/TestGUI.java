package gui;

import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class TestGUI {
    public static void main(String[] args) {

        JFrame f = new JFrame("LoL");
        f.setSize(800, 600);
        f.setLocationRelativeTo(null);
        f.setLayout(null);

        final JLabel l = new JLabel();

        ImageIcon i = new ImageIcon("resource/shana_heiheihei.png");
        l.setIcon(i);
        l.setBounds(375, 275, i.getIconWidth(), i.getIconHeight());

        f.add(l);
        l.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                Random r = new Random();
                int x = r.nextInt(f.getWidth() - l.getWidth());
                int y = r.nextInt(f.getHeight() - l.getHeight());
                l.setLocation(x, y);
                System.out.println("mouse entered");
            }
        });

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setVisible(true);
    }
}
