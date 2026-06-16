import java.io.File;
import java.io.IOException;

public class FileHandler {
    public static void checkFiles() {
        createFile("data/users.txt");
        createFile("data/budget.txt");
        createFile("data/transactions.txt");
    }

    private static void createFile(String filename) {
        try {
            File file = new File(filename);
            // Ensure parent directories exist
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            // Create the file if it doesn't exist
            if (file.createNewFile()) {
                System.out.println("Created: " + filename);
            }
        } catch (IOException e) {
            System.err.println("Error creating file: " + filename);
            e.printStackTrace();
        }
    }
}
