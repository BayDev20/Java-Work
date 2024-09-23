import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class MenuExample extends JFrame {

    private JTextField textField;
    private JPanel mainPanel;
    private float initialHue = -1; // Initial hue value

    public MenuExample() {
        setTitle("Dropdown Example");
        setSize(250, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createMenuBar();
        createUI();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");

        JMenuItem showDateTimeItem = new JMenuItem("Show Date / Time");
        showDateTimeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showDateTime();
            }
        });

        JMenuItem writeToLogFileItem = new JMenuItem("Print to Log File");
        writeToLogFileItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                writeToLogFile();
            }
        });

        JMenuItem changeBackgroundColorItem = new JMenuItem("Change Panel Color");
        changeBackgroundColorItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeBackgroundColor();
            }
        });

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menu.add(showDateTimeItem);
        menu.add(writeToLogFileItem);
        menu.add(changeBackgroundColorItem);
        menu.add(exitItem);

        menuBar.add(menu);
        setJMenuBar(menuBar);
    }

    private void createUI() {
        mainPanel = new JPanel(new BorderLayout());

        textField = new JTextField();
        mainPanel.add(textField, BorderLayout.CENTER);

        setContentPane(mainPanel);
    }

    private void showDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        textField.setText(dateFormat.format(date));
    }

    private void writeToLogFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt", true))) {
            writer.write(textField.getText());
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void changeBackgroundColor() {
        // Generate a random hue within the green range
        float minGreenHue = 90; // Minimum green hue
        float maxGreenHue = 150; // Maximum green hue
        float hue = minGreenHue + new Random().nextFloat() * (maxGreenHue - minGreenHue);
    
        Color color = Color.getHSBColor(hue / 360, 1, 1); // Convert hue to HSB format
    
        mainPanel.setBackground(color); // Set panel color
        textField.setBackground(color); // Set text field background to match panel
        repaint();
    
        // Print the hue parameters in the text field
        textField.setText("Hue: " + hue + ", Saturation: 1, Brightness: 1");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MenuExample();
            }
        });
    }
}
