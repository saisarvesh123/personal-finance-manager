import javax.swing.*;
import java.awt.*;

public class FinanceManager {
    public static void showDashboard(JFrame parent) {
        JFrame frame = new JFrame("FinTrack-Finance Manager");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Center the window

        // Main Panel Styling
        JPanel panel = new JPanel();
        panel.setBackground(new Color(45, 52, 54)); // Dark theme
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15)); // **Better Button Alignment**

        // Custom Font & Button Colors
        Font buttonFont = new Font("Arial", Font.BOLD, 14);

        JButton setBudgetButton = createStyledButton("Set Budget", buttonFont, new Color(255, 87, 34));
        JButton viewBudgetButton = createStyledButton("View Budget", buttonFont, new Color(33, 150, 243));
        JButton addTransactionButton = createStyledButton("Record Transaction", buttonFont, new Color(76, 175, 80));
        JButton viewTransactionsButton = createStyledButton("View Transactions", buttonFont, new Color(156, 39, 176));

        // Add Clickable Actions
        setBudgetButton.addActionListener(e -> BudgetManager.setBudget(frame));
        viewBudgetButton.addActionListener(e -> BudgetManager.viewBudget(frame));
        addTransactionButton.addActionListener(e -> TransactionManager.recordTransaction(frame));
        viewTransactionsButton.addActionListener(e -> TransactionManager.viewTransactions(frame));

        // Adding Buttons to Panel
        panel.add(setBudgetButton);
        panel.add(viewBudgetButton);
        panel.add(addTransactionButton);
        panel.add(viewTransactionsButton);

        // Header Label (Proper Alignment)
        JLabel headerLabel = new JLabel("Finance Manager", JLabel.CENTER);
        headerLabel.setFont(new Font("SansSerif", Font.BOLD, 22));
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setOpaque(true);
        headerLabel.setBackground(new Color(33, 37, 41));
        headerLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        // Adding Components to Frame
        frame.setLayout(new BorderLayout());
        frame.add(headerLabel, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);

        frame.setVisible(true); // Set frame visibility last
    }

    // Method to Create Styled Buttons
    private static JButton createStyledButton(String text, Font font, Color color) {
        JButton button = new JButton(text);
        button.setFont(font);
        button.setForeground(Color.WHITE);
        button.setBackground(color);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createRaisedBevelBorder());
        button.setPreferredSize(new Dimension(180, 40)); // **Proper Button Size**
        return button;
    }
}
