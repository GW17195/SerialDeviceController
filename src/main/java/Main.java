import org.jdatepicker.ComponentIconDefaults;
import org.levigao.serialport.data.UIConfig;
import org.levigao.serialport.ui.HomeFrame;
import org.levigao.serialport.ui.MainFrame;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;


public class Main {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                HomeFrame hf = new HomeFrame();
                InputStream stream = ComponentIconDefaults.class.getResourceAsStream(UIConfig.IconImagePath);
                BufferedImage image = null;
                try {
                    image = ImageIO.read(stream);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                hf.setIconImage(image);
                hf.setVisible(true);



               // new MainFrame().setVisible(true);
            }
        });
    }
}