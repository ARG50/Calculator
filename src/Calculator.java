
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

    // A+B, A*B, A-B, A/B
    String A = "0";
    String op = null;
    String B = null;

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

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton button = (JButton) e.getSource();
                    String buttonValue = button.getText();

                    if(Arrays.asList(rightSymbols).contains(buttonValue))
                    {
                        if (buttonValue == "=")
                        {
                            if(A != null && op != null)
                            {
                                B = myFrame.displayTextfield.getText();
                                double numA = Double.parseDouble(A);
                                double numB = Double.parseDouble(B);
                                if(op == "+")
                                {
                                    myFrame.displayTextfield.setText(checkWholeNum(numA+numB));
                                }
                                else if(op == "-")
                                {
                                    myFrame.displayTextfield.setText(checkWholeNum(numA-numB));
                                }
                                else if(op == "×")
                                {
                                    myFrame.displayTextfield.setText(checkWholeNum(numA*numB));
                                }
                                else if(op == "÷")
                                {
                                    myFrame.displayTextfield.setText(checkWholeNum(numA/numB));
                                }
                                clearAllDigits();
                            }
                        }
                        else if("+-÷×".contains(buttonValue))
                        {
                            if(op == null)
                            {
                                // Must be implemented for display with op.
                                A = myFrame.displayTextfield.getText();
//                                String temp;
                                myFrame.displayTextfield.setText("0");
                                B = "0";
                            }
                            op = buttonValue;
                        }
                        else
                        {

                        }
                    }
                    else if(Arrays.asList(topSymbols).contains(buttonValue))
                    {
                        if(buttonValue == "AC")
                        {
                            clearAllDigits();
                            myFrame.displayTextfield.setText("0");
                        }
                        else if(buttonValue == "+/-")
                        {
                            double displayedNum = Double.parseDouble(myFrame.displayTextfield.getText());
                            displayedNum *= -1;
                            myFrame.displayTextfield.setText(checkWholeNum(displayedNum));
                        }
                        else if(buttonValue == "%")
                        {
                            // Must be implemented later (100 - 25%) = 75

                            double displayedNum = Double.parseDouble(myFrame.displayTextfield.getText());
                            displayedNum /= 100;
                            myFrame.displayTextfield.setText(checkWholeNum(displayedNum));
                        }
                    }
                    else
                    {
                        // Num Digits or decimal point
                        if(buttonValue == ".")
                        {
                            if(!myFrame.displayTextfield.getText().contains(buttonValue))
                            {
                                myFrame.displayTextfield.setText(myFrame.displayTextfield.getText()+buttonValue);
                            }
                        }
                        else if(buttonValue == "√")
                        {
                            if(!myFrame.displayTextfield.getText().contains(buttonValue))
                            {
                                myFrame.displayTextfield.setText(buttonValue+myFrame.displayTextfield.getText());
                            }
                        }
                        else if("0123456789".contains(buttonValue))
                        {
                            if(myFrame.displayTextfield.getText() == "0")
                            {
                                myFrame.displayTextfield.setText(buttonValue);
                            }
                            else
                            {
                                myFrame.displayTextfield.setText(myFrame.displayTextfield.getText()+buttonValue);
                            }
                        }
                    }
                }
            });
        }
        myFrame.add(buttonPanel);

        // Moved here from Window Frame
        myFrame.setVisible(true);
        // Got problem in button focusable false in WindowFrame
    }

    private void clearAllDigits()
    {
        A = "0";
        op = null;
        B = null;

    }
    private String checkWholeNum(double displayedNum)
    {
        if(displayedNum % 1 == 0)
        {
            return Integer.toString((int) displayedNum);
        }
        return Double.toString(displayedNum);
    }

}
