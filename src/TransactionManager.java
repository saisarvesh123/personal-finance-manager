import javax.swing.*;
import java.io.*;

public class TransactionManager {
    private static final String TRANSACTIONS_FILE = "data/transactions.txt";

    public static void recordTransaction(JFrame parent) {
        String details = JOptionPane.showInputDialog(parent, "Enter transaction details:");

        if (details == null || details.trim().isEmpty()) {
            JOptionPane.showMessageDialog(parent, "Invalid input! Transaction not recorded.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TRANSACTIONS_FILE, true))) {
            writer.write(details.trim());
            writer.newLine();
            JOptionPane.showMessageDialog(parent, "Transaction recorded successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(parent, "Error saving transaction!", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public static void viewTransactions(JFrame parent) {
        FileHandler.checkFiles();

        File transactionFile = new File(TRANSACTIONS_FILE);
        if (!transactionFile.exists() || transactionFile.length() == 0) {
            JOptionPane.showMessageDialog(parent, "No transactions found!", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(TRANSACTIONS_FILE))) {
            StringBuilder transactions = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                transactions.append(line).append("\n");
            }
            JOptionPane.showMessageDialog(parent, transactions.toString(), "Transactions", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(parent, "Error reading transactions!", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}
