import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class QuickShift {

    public static void main(String[] args) {
        // Start with the first splash screen
        new SplashScreen1();
    }
}

class SplashScreen1 extends JFrame {

    public SplashScreen1() {
        // Set up JFrame properties
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximize the window

        // Load and scale the image dynamically
        URL imageUrl = getClass().getResource("/A1.png"); // Adjust path if needed
        if (imageUrl != null) {
            ImageIcon logoIcon = new ImageIcon(imageUrl);
            // Get the image and scale it
            Image scaledImage = logoIcon.getImage().getScaledInstance(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height, Image.SCALE_SMOOTH);
            JLabel logoLabel = new JLabel(new ImageIcon(scaledImage));
            logoLabel.setHorizontalAlignment(SwingConstants.CENTER);
            add(logoLabel);
        } else {
            System.out.println("Image not found.");
        }

        setVisible(true);

        // Timer to transition to the next screen after 3 seconds
        Timer timer = new Timer(3000, e -> {
            dispose(); // Close Splash Screen 1
            new SplashScreen2(); // Open Splash Screen 2
        });
        timer.setRepeats(false); // Only execute once
        timer.start();
    }
}

class SplashScreen2 extends JFrame {

    public SplashScreen2() {
        // Set up JFrame properties
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximize the window

        // Load and scale the second splash screen logo dynamically
        URL imageUrl = getClass().getResource("/A2.png"); // Adjust path if needed
        if (imageUrl != null) {
            ImageIcon logoIcon = new ImageIcon(imageUrl);
            // Get the image and scale it
            Image scaledImage = logoIcon.getImage().getScaledInstance(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height, Image.SCALE_SMOOTH);
            JLabel logoLabel = new JLabel(new ImageIcon(scaledImage));
            logoLabel.setHorizontalAlignment(SwingConstants.CENTER);
            add(logoLabel);
        } else {
            System.out.println("Image not found.");
        }

        setVisible(true);

        // Timer to transition to Home Page after 3 seconds
        Timer timer = new Timer(3000, e -> {
            dispose(); // Close Splash Screen 2
            new HomePage(); // Open Home Page
        });
        timer.setRepeats(false); // Only execute once
        timer.start();
    }
}

class HomePage extends JFrame {

    public HomePage() {
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximize the window
        URL bgImageUrl = getClass().getResource("/A1.png"); // Replace with your background image path
        ImageIcon backgroundImage = new ImageIcon(bgImageUrl);
        Image img = backgroundImage.getImage();
        Image scaledImage = img.getScaledInstance(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height, Image.SCALE_SMOOTH);
        JLabel backgroundLabel = new JLabel(new ImageIcon(scaledImage));

        // Create a panel for the navigation bar
        JPanel navPanel = new JPanel();
        navPanel.setLayout(new FlowLayout()); // Use FlowLayout for horizontal alignment
        navPanel.setOpaque(false); // Make it transparent

        // Add 5 JComboBoxes to the navigation bar
        for (int i = 1; i <= 5; i++) {
            JComboBox<String> comboBox = new JComboBox<>(new String[]{"Option 1", "Option 2", "Option 3", "Option 4"});
            navPanel.add(comboBox);
        }

        // Create a button to exit the application
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> System.exit(0)); // Exit the application

        // Create additional buttons as required
        JButton actionButton1 = new JButton("Action 1");
        JButton actionButton2 = new JButton("Action 2");

        // Create a panel for action buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT)); // Align buttons to the right
        buttonPanel.setOpaque(false); // Make it transparent
        buttonPanel.add(actionButton1);
        buttonPanel.add(actionButton2);
        buttonPanel.add(exitButton); // Add the exit button to the right corner

        // Set layout for the main frame
        setLayout(new BorderLayout());
        add(backgroundLabel);
        add(navPanel, BorderLayout.NORTH); // Add navigation bar at the top
        add(buttonPanel, BorderLayout.SOUTH); // Add action buttons at the bottom

        // Set the content pane to use the background image
        setContentPane(backgroundLabel);
        setVisible(true);
    }
}
