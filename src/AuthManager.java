import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class AuthManager {
    private static final String USERS_FILE = "data/users.txt";

    public static void showLoginScreen(JFrame parent) {
        JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10));
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);

        int result = JOptionPane.showConfirmDialog(parent, panel, "Login", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String username = usernameField.getText().trim();
            String password = new String(passwordField.getPassword()).trim();

            if (isValidUser(username, password)) {
                JOptionPane.showMessageDialog(parent, "Login Successful!");
                FinanceManager.showDashboard(parent);
            } else {
                JOptionPane.showMessageDialog(parent, "Invalid credentials!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void showRegisterScreen(JFrame parent) {
        JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10));
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        panel.add(new JLabel("New Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("New Password:"));
        panel.add(passwordField);

        int result = JOptionPane.showConfirmDialog(parent, panel, "Register", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String username = usernameField.getText().trim();
            String password = new String(passwordField.getPassword()).trim();

            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(parent, "Username and password cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (registerUser(username, password)) {
                JOptionPane.showMessageDialog(parent, "Registration Successful!");
            } else {
                JOptionPane.showMessageDialog(parent, "User already exists!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static boolean isValidUser(String username, String password) {
        FileHandler.checkFiles();
        try (Scanner scanner = new Scanner(new File(USERS_FILE))) {
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");
                if (data.length == 2 && data[0].equals(username) && data[1].equals(password)) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "User data file not found!", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean registerUser(String username, String password) {
        FileHandler.checkFiles();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USERS_FILE, true))) {
            writer.write(username + "," + password);
            writer.newLine();
            return true;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error saving user data!", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return false;
        }
    }
}
