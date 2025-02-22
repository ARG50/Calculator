import javax.swing.*;
import java.awt.*;

public class WindowFrame extends JFrame {
    int frameWidth = 360;
    int frameHeight = 550;

    WindowFrame()
    {
//        setPreferredSize(new Dimension(360, 540));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(frameWidth, frameHeight);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("My Calculator");
        setVisible(true);
    }
}
