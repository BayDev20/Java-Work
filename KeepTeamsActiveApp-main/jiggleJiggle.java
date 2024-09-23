import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;

public class jiggleJiggle extends JFrame {

    private Timer timer;

    public jiggleJiggle() {
        super("Mouse Jiggler");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 100);
        setLayout(new FlowLayout());

        JButton startButton = new JButton("Start");
        JButton stopButton = new JButton("Stop");

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startMouseJiggling();
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopMouseJiggling();
            }
        });

        add(startButton);
        add(stopButton);

        timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jiggleMouse();
            }
        });
    }

    private void startMouseJiggling() {
        timer.start();
    }

    private void stopMouseJiggling() {
        timer.stop();
    }

    private int dx = 5;
private int dy = 5;

private void jiggleMouse() {
    try {
        Robot robot = new Robot();
        Point currentMouseLocation = MouseInfo.getPointerInfo().getLocation();
        
        // Check if we reached the screen edge
        if (currentMouseLocation.getX() + dx >= Toolkit.getDefaultToolkit().getScreenSize().getWidth() ||
            currentMouseLocation.getX() + dx <= 0) {
            // Reverse direction in X axis
            dx = -dx;
        }
        
        if (currentMouseLocation.getY() + dy >= Toolkit.getDefaultToolkit().getScreenSize().getHeight() ||
            currentMouseLocation.getY() + dy <= 0) {
            // Reverse direction in Y axis
            dy = -dy;
        }

        // Move the mouse by a small amount
        robot.mouseMove((int) currentMouseLocation.getX() + dx, (int) currentMouseLocation.getY() + dy);
    } catch (AWTException e) {
        e.printStackTrace();
    }
}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new jiggleJiggle().setVisible(true);  // Corrected class name here
            }
        });
    }
}