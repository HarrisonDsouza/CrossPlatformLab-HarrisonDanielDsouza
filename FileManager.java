import java.io.*;
import java.nio.file.*;

public class FileManager {

    /**
     * Creates a new file with the given name and content
     */
    public boolean createFile(String fileName, String content) {
        try {
            Path path = Paths.get(fileName);
            Files.writeString(path, content);
            System.out.println("File created successfully: " + fileName);
            return true;
        } catch (IOException e) {
            System.err.println("Error creating file: " + e.getMessage());
            return false;
        }
    }

    /**
     * Reads content from a file
     */
    public String readFile(String fileName) {
        try {
            Path path = Paths.get(fileName);
            return Files.readString(path);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return null;
        }
    }

    /**
     * Deletes a file
     */
    public boolean deleteFile(String fileName) {
        try {
            Path path = Paths.get(fileName);
            Files.delete(path);
            System.out.println("File deleted successfully: " + fileName);
            return true;
        } catch (IOException e) {
            System.err.println("Error deleting file: " + e.getMessage());
            return false;
        }
    }

    /**
     * Checks if a file exists
     */
    public boolean fileExists(String fileName) {
        Path path = Paths.get(fileName);
        return Files.exists(path);
    }

    /**
     * Main method for testing
     */
    public static void main(String[] args) {
        FileManager fm = new FileManager();

        // Test file operations
        String testFile = "test.txt";
        String testContent = "Hello, this is a test file!";

        fm.createFile(testFile, testContent);

        if (fm.fileExists(testFile)) {
            System.out.println("File exists: " + testFile);
            String content = fm.readFile(testFile);
            System.out.println("Content: " + content);
        }

        fm.deleteFile(testFile);
    }
}
