
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Calculator {

    WindowFrame myFrame;

    JPanel buttonPanel = new JPanel();

    String[] buttonValues = {
            "AC", "+/-", "%", "÷",
            "7", "8", "9", "×",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            "0", ".", "√", "="
    };

    String[] rightSymbols = {"÷", "×", "-", "+", "="};
    String[] topSymbols = {"AC", "+/-", "%"};

    Calculator()
    {
        Image calcIcon = new ImageIcon(getClass().getResource("calculator.png")).getImage();
        myFrame = new WindowFrame();
        myFrame.setIconImage(calcIcon);

        buttonPanel.setLayout(new GridLayout(5, 4));
        buttonPanel.setBackground(myFrame.customBlack);

        // Set all buttons from String values to button panel.
        for(int i = 0; i < buttonValues.length; i++)
        {
            JButton button = new JButton();
            String buttonValue = buttonValues[i];
            button.setFont(new Font("Arial", Font.PLAIN, 35));
            button.setText(buttonValue);
            button.setFocusable(false);
            button.setBorder(new LineBorder(myFrame.customBlack));
            if(Arrays.asList(topSymbols).contains(buttonValue))
            {
                button.setBackground(myFrame.customLightGrey);
                button.setForeground(myFrame.customBlack);
            }
            else if(Arrays.asList(rightSymbols).contains(buttonValue))
            {
                button.setBackground(myFrame.customOrange);
                button.setForeground(Color.WHITE);
            }
            else
            {
                button.setBackground(myFrame.customDarkGrey);
                button.setForeground(Color.WHITE);
            }

            buttonPanel.add(button);
        }
        myFrame.add(buttonPanel);

        // Moved here from Window Frame
        myFrame.setVisible(true);
        // Got problem in button focusable false in WindowFrame
    }

}
