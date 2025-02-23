
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;

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
        myFrame = new WindowFrame();
        buttonPanel.setLayout(new GridLayout(5, 4));
        buttonPanel.setBackground(myFrame.customBlack);
        myFrame.add(buttonPanel);

    }

}
