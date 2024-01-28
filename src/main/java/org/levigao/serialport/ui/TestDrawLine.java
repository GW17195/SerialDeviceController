package org.levigao.serialport.ui;


import javax.swing.*;
        import java.awt.*;
        import java.awt.geom.*;

class TestDrawLine extends JFrame{

    public TestDrawLine(){
        JPanel panel=new JPanel();
        getContentPane().add(panel);
        setSize(450,450);

        JButton button =new JButton("press");
        panel.add(button);
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Line2D lin = new Line2D.Float(100, 100, 250, 260);
        g2.draw(lin);
    }

    public static void main(String []args){
        TestDrawLine s=new TestDrawLine();
        s.setVisible(true);
    }
}