package org.levigao.serialport.ui;


import javax.swing.*;
        import java.awt.*;


public class DrawLineJPanel extends JPanel {

    public void paintComponent(Graphics g) {

        //vertical line
        g.setColor(Color.red);
        g.drawLine(20, 20, 20, 120);

        //horizontal line
        g.setColor(Color.green);
        g.drawLine(20, 20, 120, 20);

        //diagonal line
        g.setColor(Color.blue);
        g.drawLine(20, 20, 120, 120);



    }

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Draw Line");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(200, 200);

        DrawLineJPanel panel = new DrawLineJPanel();

        frame.add(panel);

        frame.setVisible(true);
    }
}