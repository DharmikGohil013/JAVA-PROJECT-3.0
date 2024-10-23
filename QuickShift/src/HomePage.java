import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class HomePage extends JFrame {

    public HomePage() {
        // Set up JFrame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximize the window

        // Load background image
        URL bgImageUrl = getClass().getClassLoader().getResource("A1.png"); // Replace with actual image path
        JLabel backgroundLabel = new JLabel();
        if (bgImageUrl != null) {
            ImageIcon backgroundImage = new ImageIcon(bgImageUrl);
            Image img = backgroundImage.getImage().getScaledInstance(
                    Toolkit.getDefaultToolkit().getScreenSize().width,
                    Toolkit.getDefaultToolkit().getScreenSize().height,
                    Image.SCALE_SMOOTH);
            backgroundLabel.setIcon(new ImageIcon(img));
            backgroundLabel.setBounds(0, 0, getWidth(), getHeight()); // Set size of the label
        } else {
            System.out.println("Background image not found.");
        }

        // Create navigation bar panel (top panel)
        JPanel navPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 20)); // Left alignment with padding
        navPanel.setOpaque(false); // Transparent panel
        navPanel.setPreferredSize(new Dimension(getWidth(), 60)); // Set preferred size of the navigation bar

        // Create and add 5 JComboBox components to the navigation bar
        for (int i = 1; i <= 5; i++) {
            JComboBox<String> comboBox = new JComboBox<>(new String[]{"Option " + i + ".1", "Option " + i + ".2", "Option " + i + ".3"});
            comboBox.setPreferredSize(new Dimension(150, 30)); // Set size of JComboBox
            navPanel.add(comboBox);
        }

        // Create button panel (bottom panel for buttons)
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT)); // Right-aligned layout
        buttonPanel.setOpaque(false); // Transparent panel

        // Create "Back" button and set its properties
        JButton backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(100, 40));
        backButton.addActionListener(e -> {
            // Action to perform on clicking back (you can add navigation logic here)
            System.out.println("Back button clicked.");
            dispose(); // Closes the home page
        });

        // Add "Back" button to the button panel
        buttonPanel.add(backButton);

        // Layering the background image and components using JLayeredPane
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setLayout(null); // Use null layout for manual positioning

        // Add the background label to the bottom layer
        backgroundLabel.setBounds(0, 0, Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
        layeredPane.add(backgroundLabel, JLayeredPane.DEFAULT_LAYER); // Background at the back (default layer)

        // Create a panel to hold the other components (navigation bar, buttons)
        JPanel frontPanel = new JPanel(new BorderLayout());
        frontPanel.setBounds(0, 0, Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height); // Full screen
        frontPanel.setOpaque(false); // Transparent panel for front components

        // Add navigation panel to the top
        frontPanel.add(navPanel, BorderLayout.NORTH);

        // Add button panel to the bottom
        frontPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Add the frontPanel to the higher layer
        layeredPane.add(frontPanel, JLayeredPane.PALETTE_LAYER); // Components at the front

        // Add the layeredPane to the frame
        add(layeredPane);

        // Set visibility and pack the components
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        // Run the home page
        new HomePage();
    }
}
