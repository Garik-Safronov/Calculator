package progect;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

    private JTextField textField;
    private Font textFieldFont = new Font("SanSerif", Font.BOLD, 28);
    private Font btnFont = new Font("SanSerif", Font.BOLD, 20);

    private JButton[] btnNumbers = new JButton[10];
    private JButton btnPlus, btnMinus, btnMultiplication, btnDivision, btnC,btnPlusMinus, btnPercent, btnPoint, btnEquals;

    private String action = "";
    private double num1 = 0;
    private double num2 = 0;
    private double result = 0;

    public Panel() {
        setLayout(null);

        textField = new JTextField();
        textField.setBounds(10, 10, 290, 60);
        textField.setFont(textFieldFont);
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setEditable(false);
        add(textField);

        for (int i = 0; i < btnNumbers.length; i++) {
            btnNumbers[i] = new JButton(String.valueOf(i));
            btnNumbers[i].setFont(btnFont);
            add(btnNumbers[i]);
            int number = i;
            btnNumbers[i].addActionListener(e -> {
                if (action.equals("")) {
                    textField.setText(textField.getText() + number);
                    num1 = Double.parseDouble(textField.getText());
                } else {
                    textField.setText(textField.getText() + number);
                    num2 = Double.parseDouble(textField.getText());
                }
            });
        }
        btnNumbers[0].setBounds(20, 370, 130, 60);
        btnNumbers[1].setBounds(20, 300, 60, 60);
        btnNumbers[2].setBounds(90, 300, 60, 60);
        btnNumbers[3].setBounds(160, 300, 60, 60);
        btnNumbers[4].setBounds(20, 230, 60, 60);
        btnNumbers[5].setBounds(90, 230, 60, 60);
        btnNumbers[6].setBounds(160, 230, 60, 60);
        btnNumbers[7].setBounds(20, 160, 60, 60);
        btnNumbers[8].setBounds(90, 160, 60, 60);
        btnNumbers[9].setBounds(160, 160, 60, 60);

        btnPlus = new JButton("+");
        btnPlus.setBounds(230, 300, 60, 60);
        btnPlus.setFont(btnFont);
        add(btnPlus);
        btnPlus.addActionListener(e -> {
            action = "+";
            textField.setText("");
        });

        btnMinus = new JButton("-");
        btnMinus.setBounds(230, 230, 60, 60);
        btnMinus.setFont(btnFont);
        add(btnMinus);
        btnMinus.addActionListener(e -> {
            action = "-";
            textField.setText("");
        });

        btnMultiplication = new JButton("*");
        btnMultiplication.setBounds(230, 160, 60, 60);
        btnMultiplication.setFont(btnFont);
        add(btnMultiplication);
        btnMultiplication.addActionListener(e -> {
            action = "*";
            textField.setText("");
        });

        btnDivision = new JButton("/");
        btnDivision.setBounds(230, 90, 60, 60);
        btnDivision.setFont(btnFont);
        add(btnDivision);
        btnDivision.addActionListener(e -> {
            action = "/";
            textField.setText("");
        });

        btnC = new JButton("C");
        btnC.setBounds(20, 90, 60, 60);
        btnC.setFont(btnFont);
        add(btnC);
        btnC.addActionListener(e -> {
            num1 = 0;
            num2 = 0;
            action = "";
            textField.setText("");
        });

        btnPlusMinus = new JButton("+/-");
        btnPlusMinus.setBounds(90, 90, 60, 60);
        btnPlusMinus.setFont(btnFont);
        add(btnPlusMinus);
        btnPlusMinus.addActionListener(e -> {
            char c = textField.getText().charAt(0);
            if (c != '-') {
                textField.setText("-" + textField.getText());
                if (action.equals("")) {
                    num1 = Double.parseDouble(textField.getText());
                } else {
                    num2 = Double.parseDouble(textField.getText());
                }
            } else {
                textField.setText(textField.getText().substring(1));
                if (action.equals("")) {
                    num1 = Double.parseDouble(textField.getText());
                } else {
                    num2 = Double.parseDouble(textField.getText());
                }
            }
        });

        btnPercent = new JButton("%");
        btnPercent.setBounds(160, 90, 60, 60);
        btnPercent.setFont(btnFont);
        add(btnPercent);
        btnPercent.addActionListener(e -> {
            num2 = num1 * (num2 / 100);
            textField.setText(String.valueOf(num2));
        });

        btnPoint = new JButton(",");
        btnPoint.setBounds(160, 370, 60, 60);
        btnPoint.setFont(btnFont);
        add(btnPoint);
        btnPoint.addActionListener(e -> {
            String s = textField.getText();
            if (!s.contains(".")) {
                textField.setText(s + ".");
            }
        });

        btnEquals = new JButton("=");
        btnEquals.setBounds(230, 370, 60, 60);
        btnEquals.setFont(btnFont);
        add(btnEquals);
        btnEquals.addActionListener(e -> {
            switch (action) {
                case "+" -> result = num1 + num2;
                case "-" -> result = num1 - num2;
                case "*" -> result = num1 * num2;
                case "/" -> result = num1 / num2;
            }
            String res = String.valueOf(result);
            if (result % 1 == 0) {
                textField.setText(res.substring(0,res.length() - 2));
            } else {
                textField.setText(res);
            }
            num1 = result;
            num2 = 0;
            action = "";
        });
    }
}
