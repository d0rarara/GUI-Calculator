import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CalcGUI extends JPanel implements ActionListener {

    private JTextField display;
    private JButton[] numberButtons;
    private JButton[] operatorButtons;
    JButton clearButton;
    private double num1, num2;
    private String operator;
    private boolean isFirstOperand;

    public CalcGUI(){
        setLayout(new BorderLayout()); 
        
        // Create the display field 
        display = new JTextField();
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        // Create the buttons
        JPanel numberPanel = new JPanel(new GridLayout(4, 3));
        numberButtons = new JButton[10];
        int[] numberOrder = {7, 8, 9, 4, 5, 6, 1, 2, 3, 0};
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(Integer.toString(numberOrder[i]));
            numberPanel.add(numberButtons[i]);
            numberButtons[i].addActionListener(this);
        }
        add(numberPanel, BorderLayout.CENTER);

        // Create the operator buttons
        JPanel operatorPanel = new JPanel(new GridLayout(4, 1));
        
        // Create the clear button
        clearButton = new JButton("C");
        operatorPanel.add(clearButton);
        // add(clearButton, BorderLayout.SOUTH);
        clearButton.addActionListener(this);

        operatorButtons = new JButton[5];
        operatorButtons[0] = new JButton("+");
        operatorButtons[1] = new JButton("-");
        operatorButtons[2] = new JButton("*");
        operatorButtons[3] = new JButton("/");
        operatorButtons[4] = new JButton("=");
        for (int i = 0; i < 5; i++) {
            operatorPanel.add(operatorButtons[i]);
            operatorButtons[i].addActionListener(this);
        }
        add(operatorPanel, BorderLayout.EAST);
        
        // Initialize variables
        num1 = 0;
        num2 = 0;
        operator = "";
        isFirstOperand = true;
    }

    // ActionListener interface handles button clicks 
    // Add the action listeners to the buttons
    public void actionPerformed(ActionEvent e){
        String command = e.getActionCommand();

        if (command.equals("+")) {
            // Set the operator to + and store the first operand
            operator = "+";
            num1 = Double.parseDouble(display.getText());
            isFirstOperand = false;
            display.setText("");
        } else if (command.equals("-")) {
            // Set the operator to - and store the first operand
            operator = "-";
            num1 = Double.parseDouble(display.getText());
            isFirstOperand = false;
            display.setText("");
        } else if (command.equals("*")) {
            // Set the operator to * and store the first operand
            operator = "*";
            num1 = Double.parseDouble(display.getText());
            isFirstOperand = false;
            display.setText("");
        } else if (command.equals("/")) {
            // Set the operator to / and store the first operand
            operator = "/";
            num1 = Double.parseDouble(display.getText());
            isFirstOperand = false;
            display.setText("");
        } else if (command.equals("=")) {
            // Store the second operand and perform the operation
            // Display the result
            num2 = Double.parseDouble(display.getText());
            if (operator.equals("+")) {
                display.setText(Double.toString(num1 + num2));
            } else if (operator.equals("-")) {
                display.setText(Double.toString(num1 - num2));
            } else if (operator.equals("*")) {
                display.setText(Double.toString(num1 * num2));
            } else if (operator.equals("/")) {
                display.setText(Double.toString(num1 / num2));
            }
            isFirstOperand = true;
        } else if (command.equals("C")) {
            display.setText("");
            num1 = 0;
            num2 = 0;
            operator = "";
            isFirstOperand = true;
        } else {
            if (isFirstOperand) {
                display.setText(command);
                isFirstOperand = false;
            } else {
                display.setText(display.getText() + command);
            }
        }
    }

    public static void main(String[] args){
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new CalcGUI());
        frame.pack();
        frame.setVisible(true);
    }
}
