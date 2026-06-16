import javax.swing.*;
import java.io.*;

public class BudgetManager {
    private static final String BUDGET_FILE = "data/budget.txt";

    public static void setBudget(JFrame parent) {
        String amount = JOptionPane.showInputDialog(parent, "Enter your monthly budget:");

        if (amount == null || amount.trim().isEmpty()) {
            JOptionPane.showMessageDialog(parent, "Invalid input! Budget not set.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BUDGET_FILE))) {
            writer.write(amount.trim());
            JOptionPane.showMessageDialog(parent, "Budget set successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(parent, "Error saving budget!", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public static void viewBudget(JFrame parent) {
        FileHandler.checkFiles();

        File budgetFile = new File(BUDGET_FILE);
        if (!budgetFile.exists() || budgetFile.length() == 0) {
            JOptionPane.showMessageDialog(parent, "No budget set yet!", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(BUDGET_FILE))) {
            String amount = reader.readLine();
            JOptionPane.showMessageDialog(parent, "Your monthly budget: " + (amount != null ? amount : "Not Set"), "Budget Info", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(parent, "Error reading budget!", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}
