package org.levigao.serialport.ui;

/*
* https://www.javacodex.com/Graphics/Drawing-Lines
* */
import org.levigao.serialport.data.UIConfig;

import javax.swing.*;
        import java.awt.*;


public class DrawLineJPanel extends JPanel {

    public void paintComponent(Graphics g) {

        //vertical line
      /*  g.setColor(Color.red);
        g.drawLine(20, 20, 20, 120);*/

        //horizontal line
        g.setColor(Color.red);
        g.drawLine(20+UIConfig.CHINESE_CHARACTER_WIDTH*18,
                30+UIConfig.CHINESE_CHARACTER_WIDTH*12,
                20+UIConfig.CHINESE_CHARACTER_WIDTH*75,
                30+UIConfig.CHINESE_CHARACTER_WIDTH*12);

        //diagonal line
     /*   g.setColor(Color.blue);
        g.drawLine(20, 20, 120, 120);*/



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