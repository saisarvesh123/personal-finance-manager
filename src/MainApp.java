import javax.swing.*;
import java.awt.*;

public class MainApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("FinTrack - Personal Finance Manager");
            frame.setSize(600, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());
            frame.setLocationRelativeTo(null); // Center window

            // Title Label
            JLabel titleLabel = new JLabel("FinTrack - Personal Finance Manager", SwingConstants.CENTER);
            titleLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
            titleLabel.setForeground(Color.WHITE);
            titleLabel.setOpaque(true);
            titleLabel.setBackground(new Color(45, 52, 54));
            titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

            // Button Panel (Proper Width, Reduced Height)
            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20)); // Centered buttons with spacing
            buttonPanel.setBackground(new Color(45, 52, 54));

            JButton loginButton = createStyledButton("Login", new Color(255, 193, 7), 120, 35); // Proper width, reduced height
            JButton registerButton = createStyledButton("Register", new Color(76, 175, 80), 120, 35);

            loginButton.addActionListener(e -> AuthManager.showLoginScreen(frame));
            registerButton.addActionListener(e -> AuthManager.showRegisterScreen(frame));

            buttonPanel.add(loginButton);
            buttonPanel.add(registerButton);

            // Main Content Panel
            JPanel mainPanel = new JPanel(new BorderLayout());
            mainPanel.setBackground(new Color(33, 37, 41));
            mainPanel.add(titleLabel, BorderLayout.NORTH);
            mainPanel.add(buttonPanel, BorderLayout.CENTER);

            // Frame Layout
            frame.add(mainPanel, BorderLayout.CENTER);
            frame.setVisible(true);
        });
    }

    // Method to Create Properly Sized Buttons
    private static JButton createStyledButton(String text, Color color, int width, int height) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14)); // Normal font size
        button.setForeground(Color.BLACK);
        button.setBackground(color);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createRaisedBevelBorder());
        button.setPreferredSize(new Dimension(width, height)); // Proper width, reduced height
        return button;
    }
}
