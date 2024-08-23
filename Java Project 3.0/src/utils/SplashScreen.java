package utils;
import javax.swing.*;
import java.awt.*;

public class SplashScreen extends JFrame {

    public SplashScreen() {
        // Set up the splash screen frame
        setSize(400, 300); // Set the size of the splash screen window
        setLocationRelativeTo(null); // Center the window
        setUndecorated(true); // Remove window borders and title bar

        // Create a panel for displaying the logo
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE); // Set background color to white

        // Create a label for the logo text
        JLabel label = new JLabel("GDGS Systems");
        label.setFont(new Font("Arial", Font.BOLD, 60)); // Set font and size
        label.setForeground(Color.BLACK); // Set text color

        // Add the label to the panel
        panel.add(label);

        // Add the panel to the frame
        add(panel);

        // Make the splash screen visible
        setVisible(true);

        // Set a timer to close the splash screen after 3 seconds (3000 milliseconds)
        Timer timer = new Timer(3000, e -> {
            dispose(); // Close the splash screen
            new MainMenu(); // Open the main menu page
        });
        timer.setRepeats(false); // The timer should not repeat
        timer.start(); // Start the timer
    }

    public static void main(String[] args) {
        // Run the splash screen in the event dispatch thread for thread safety
        SwingUtilities.invokeLater(SplashScreen::new);
    }
}
