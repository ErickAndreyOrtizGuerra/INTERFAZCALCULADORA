import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class calculadora extends JFrame {
    private JTextField displayField;
    private JButton[] numberButtons;
    private JButton addButton, subtractButton, multiplyButton, divideButton, equalButton;
    private JButton sinButton, cosButton, tanButton, sqrtButton, factorialButton, decimalButton;
    private JButton clearButton;

    private double num1;
    private String operator;
    private boolean newInput;

    public calculadora() {
        super("Calculadora Especial De Erick Ortiz");

        // Configuración de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.BLACK);

        // Creación de los componentes
        displayField = new JTextField(15);
        displayField.setHorizontalAlignment(JTextField.RIGHT);
        displayField.setEditable(false);
        displayField.setFont(new Font("Arial", Font.PLAIN, 32));

        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            final int digit = i;
            numberButtons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    appendDigit(digit);
                }
            });
            numberButtons[i].setBackground(Color.LIGHT_GRAY);
            numberButtons[i].setForeground(Color.BLACK);
        }

        addButton = new JButton("Suma");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setOperator("+");
            }
        });
        addButton.setBackground(Color.PINK);
        addButton.setForeground(Color.WHITE);

        subtractButton = new JButton("Resta");
        subtractButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setOperator("-");
            }
        });
        subtractButton.setBackground(Color.BLUE);
        subtractButton.setForeground(Color.WHITE);

        multiplyButton = new JButton("Multiplicacion");
        multiplyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setOperator("*");
            }
        });
        multiplyButton.setBackground(Color.RED);
        multiplyButton.setForeground(Color.WHITE);

        divideButton = new JButton("Division");
        divideButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setOperator("/");
            }
        });
        divideButton.setBackground(Color.YELLOW);
        divideButton.setForeground(Color.WHITE);

        equalButton = new JButton("=");
        equalButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculate();
            }
        });
        equalButton.setBackground(Color.GREEN);
        equalButton.setForeground(Color.WHITE);

        sinButton = new JButton("sin");
        sinButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateSpecialFunction("sin");
            }
        });
        sinButton.setBackground(Color.BLACK);
        sinButton.setForeground(Color.WHITE);

        cosButton = new JButton("cos");
        cosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateSpecialFunction("cos");
            }
        });
        cosButton.setBackground(Color.GREEN);
        cosButton.setForeground(Color.WHITE);

        tanButton = new JButton("tan");
        tanButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateSpecialFunction("tan");
            }
        });
        tanButton.setBackground(Color.GRAY);
        tanButton.setForeground(Color.WHITE);

        sqrtButton = new JButton("Raiz");
        sqrtButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateSpecialFunction("sqrt");
            }
        });
        sqrtButton.setBackground(Color.ORANGE);
        sqrtButton.setForeground(Color.WHITE);

        factorialButton = new JButton("Factorial");
        factorialButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateSpecialFunction("factorial");
            }
        });
        factorialButton.setBackground(Color.PINK);
        factorialButton.setForeground(Color.WHITE);

        decimalButton = new JButton(".");
        decimalButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                appendDecimal();
            }
        });
        decimalButton.setBackground(Color.LIGHT_GRAY);
        decimalButton.setForeground(Color.BLACK);

        clearButton = new JButton("C");
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearDisplay();
            }
        });
        clearButton.setBackground(Color.RED);
        clearButton.setForeground(Color.WHITE);

        // Configuración del diseño de la calculadora
        JPanel contentPane = new JPanel(new BorderLayout(10, 10));
        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        contentPane.setBackground(Color.WHITE);

        JPanel buttonPanel = new JPanel(new GridLayout(6, 4, 10, 10));
        buttonPanel.setBackground(Color.WHITE);

        buttonPanel.add(sinButton);
        buttonPanel.add(cosButton);
        buttonPanel.add(tanButton);
        buttonPanel.add(sqrtButton);

        for (int i = 7; i <= 9; i++) {
            buttonPanel.add(numberButtons[i]);
        }
        buttonPanel.add(divideButton);

        for (int i = 4; i <= 6; i++) {
            buttonPanel.add(numberButtons[i]);
        }
        buttonPanel.add(multiplyButton);

        for (int i = 1; i <= 3; i++) {
            buttonPanel.add(numberButtons[i]);
        }
        buttonPanel.add(subtractButton);

        buttonPanel.add(numberButtons[0]);
        buttonPanel.add(factorialButton);
        buttonPanel.add(equalButton);
        buttonPanel.add(addButton);

        buttonPanel.add(decimalButton);
        buttonPanel.add(clearButton);

        contentPane.add(displayField, BorderLayout.NORTH);
        contentPane.add(buttonPanel, BorderLayout.CENTER);

        setContentPane(contentPane);
        pack();
    }

    private void appendDigit(int digit) {
        if (newInput) {
            displayField.setText(String.valueOf(digit));
            newInput = false;
        } else {
            displayField.setText(displayField.getText() + digit);
        }
    }

    private void setOperator(String op) {
        num1 = Double.parseDouble(displayField.getText());
        operator = op;
        newInput = true;
    }

    private void calculate() {
        double num2 = Double.parseDouble(displayField.getText());
        double result = 0;

        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
        }

        displayField.setText(String.valueOf(result));
        newInput = true;
    }

    private void calculateSpecialFunction(String functionName) {
        double num = Double.parseDouble(displayField.getText());
        double result = 0;

        switch (functionName) {
            case "sin":
                result = Math.sin(num);
                break;
            case "cos":
                result = Math.cos(num);
                break;
            case "tan":
                result = Math.tan(num);
                break;
            case "sqrt":
                result = Math.sqrt(num);
                break;
            case "factorial":
                result = factorial(num);
                break;
        }

        displayField.setText(String.valueOf(result));
        newInput = true;
    }

    private double factorial(double n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    private void appendDecimal() {
        if (!displayField.getText().contains(".")) {
            displayField.setText(displayField.getText() + ".");
        }
    }

    private void clearDisplay() {
        displayField.setText("");
        newInput = true;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                calculadora calculadora = new calculadora();
                calculadora.setVisible(true);
            }
        });
    }
}
