import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Properties;

public class MyBankBalanceApp extends JFrame {
    private JTextField amountTextField;
    private JLabel resultLabel;

    private double currentBalance = 0.0;
    private static final String CONFIG_FILE = "balance_config.properties";

    public MyBankBalanceApp() {
        loadBalance();

        setTitle("My Bank Balance");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(4, 2));

        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");

        resultLabel = new JLabel("Current Balance: $" + currentBalance);

        JLabel amountLabel = new JLabel("Amount:");
        amountTextField = new JTextField();

        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateBalance(true);
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateBalance(false);
            }
        });

        mainPanel.add(amountLabel);
        mainPanel.add(amountTextField);
        mainPanel.add(depositButton);
        mainPanel.add(withdrawButton);

        add(mainPanel, BorderLayout.CENTER);
        add(resultLabel, BorderLayout.SOUTH);

        // Set color theme
        mainPanel.setBackground(new Color(173, 216, 230)); // Light Blue
        depositButton.setBackground(new Color(0, 128, 0)); // Green
        withdrawButton.setBackground(new Color(255, 0, 0)); // Red

        resultLabel.setHorizontalAlignment(JLabel.CENTER);

        setVisible(true);

        // Save balance when the program exits
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                saveBalance();
            }
        });
    }

    private void updateBalance(boolean isDeposit) {
        try {
            double amount = Double.parseDouble(amountTextField.getText());
            if (isDeposit) {
                currentBalance += amount;
            } else {
                if (amount > currentBalance) {
                    JOptionPane.showMessageDialog(MyBankBalanceApp.this, "Insufficient funds");
                    return;
                }
                currentBalance -= amount;
            }
            saveBalance();
            displayBalance();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(MyBankBalanceApp.this, "Invalid input for amount");
        }
    }

    private void displayBalance() {
        resultLabel.setText("Current Balance: $" + currentBalance);
    }

    private void saveBalance() {
        try (OutputStream output = new FileOutputStream(CONFIG_FILE)) {
            Properties prop = new Properties();
            prop.setProperty("balance", String.valueOf(currentBalance));
            prop.store(output, null);
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    private void loadBalance() {
        try (InputStream input = new FileInputStream(CONFIG_FILE)) {
            Properties prop = new Properties();

            // Load a properties file
            prop.load(input);

            // Get the property value and set the current balance
            String balanceStr = prop.getProperty("balance");
            if (balanceStr != null) {
                currentBalance = Double.parseDouble(balanceStr);
            }
        } catch (IOException | NumberFormatException io) {
            // Ignore errors, use default balance
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MyBankBalanceApp();
            }
        });
    }
}







