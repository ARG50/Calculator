import javax.swing.*;
import java.awt.*;

public class WindowFrame extends JFrame {
    private int frameWidth = 400;
    private int frameHeight = 550;

    JScrollPane displayScrollPanel = new JScrollPane();
    JPanel displayPanel = new JPanel();
    JLabel displayLabel = new JLabel();

    // Reference from Iphone Calculator colors.
    protected Color customLightGrey = new Color(212, 212,210);
    protected Color customBlack = new Color(28, 28, 28);
    protected Color customDarkGrey = new Color(80, 80, 80);
    protected Color customOrange = new Color(255, 149, 0);

    WindowFrame()
    {
//        setPreferredSize(new Dimension(360, 540));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setSize(frameWidth, frameHeight);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setTitle("My Calculator");

        displayLabel.setBackground(customBlack);
        displayLabel.setForeground(Color.WHITE);
        displayLabel.setFont(new Font("Arial", Font.PLAIN, 80));
        displayLabel.setHorizontalAlignment(JLabel.RIGHT);
        displayLabel.setText("0");
//        displayLabel.setAutoscrolls(true);
        displayLabel.setOpaque(true);

        displayPanel.setLayout(new BorderLayout());
//        displayPanel.setAlignmentX(JPanel.RIGHT_ALIGNMENT);

        displayPanel.add(displayLabel);
        displayScrollPanel.getViewport().setView(displayPanel);

//        displayScrollPanel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        displayScrollPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        displayScrollPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        this.add(displayScrollPanel, BorderLayout.NORTH);

    }
}
