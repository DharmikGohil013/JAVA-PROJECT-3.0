package utils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {

    public MainMenu() {
        // Set up the main menu frame
        setTitle("Main Menu");
        setSize(800, 600); // Set the size of the main menu window
        setLocationRelativeTo(null); // Center the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the application when the window is closed

        // Create a panel for the main menu
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1)); // Layout with 4 rows and 1 column

        // Create buttons for each section
        JButton studentButton = new JButton("Student");
        JButton facultyButton = new JButton("Faculty");
        JButton adminButton = new JButton("Admin");
        JButton exitButton = new JButton("Exit");

        // Set larger font size for buttons
        Font buttonFont = new Font("Arial", Font.BOLD, 24); // Font type, style, and size
        studentButton.setFont(buttonFont);
        facultyButton.setFont(buttonFont);
        adminButton.setFont(buttonFont);
        exitButton.setFont(buttonFont);

        // Add action listeners to the buttons
        studentButton.addActionListener(e -> showStudentSection());
        facultyButton.addActionListener(e -> showFacultySection());
        adminButton.addActionListener(e -> showAdminSection());
        exitButton.addActionListener(e -> exitApplication());

        // Add the buttons to the panel
        panel.add(studentButton);
        panel.add(facultyButton);
        panel.add(adminButton);
        panel.add(exitButton);

        // Add the panel to the frame
        add(panel);

        // Make the main menu visible
        setVisible(true);
    }

    private void showStudentSection() {
        // Placeholder for student section functionality
        JOptionPane.showMessageDialog(this, "Student section clicked");
    }

    private void showFacultySection() {
        // Placeholder for faculty section functionality
        JOptionPane.showMessageDialog(this, "Faculty section clicked");
    }

    private void showAdminSection() {
        // Placeholder for admin section functionality
        JOptionPane.showMessageDialog(this, "Admin section clicked");
    }

    private void exitApplication() {
        // Confirm exit and close the application
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        // Run the main menu in the event dispatch thread for thread safety
        SwingUtilities.invokeLater(MainMenu::new);
    }
}
