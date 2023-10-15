package progect;

import javax.swing.*;

public class Calculator extends JFrame {

    private JFrame window;

    public static void main(String[] args) {
        new Calculator();
    }

    public Calculator() {
        window = new JFrame("Calculator");
        window.setBounds(600, 200, 320, 480);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setResizable(false);
        window.add(new Panel());
        window.setVisible(true);
    }
}
