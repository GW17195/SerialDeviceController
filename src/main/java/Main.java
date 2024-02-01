import org.jdatepicker.ComponentIconDefaults;
import org.levigao.serialport.data.UIConfig;
import org.levigao.serialport.ui.HomePage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;


public class Main {

    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Main main = new Main();
                main.initFrame();
                main.prepareGUI();

            }
        });
    }
    private void prepareGUI(){
        frame.add(panel);
        CardLayout layout = new CardLayout();
        panel.setLayout(layout);


        JPanel textBoxPanel = new JPanel(new FlowLayout());
        textBoxPanel.add(new JLabel("Name:"));
        textBoxPanel.add(new JTextField(20));


        HomePage homePage = new HomePage();
        JPanel homePanel = homePage.getHomePanel();



        panel.add("Text", textBoxPanel);
        panel.add("homePanel", homePanel);

        frame.setVisible(true);

        CardLayout cardLayout = (CardLayout)(panel.getLayout());
        cardLayout.show(panel, "homePanel");

    }

    private void  initFrame() {
        InputStream stream = ComponentIconDefaults.class.getResourceAsStream(UIConfig.IconImagePath);
        BufferedImage image = null;
        try {
            image = ImageIO.read(stream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        frame.setIconImage(image);
        frame.setVisible(true);

        // 关闭程序
        frame. setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        // 禁止窗口最大化
        frame. setResizable(false);
        // 设置程序窗口居中显示
        Point p = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        frame. setBounds(p.x - UIConfig.WINDOW_WIDTH / 2, p.y - UIConfig.WINDOW_HEIGHT / 2,
                UIConfig.WINDOW_WIDTH, UIConfig.WINDOW_HEIGHT);
        // frame.setLayout(null);
        frame.setTitle(UIConfig.UITitle);
    }
}