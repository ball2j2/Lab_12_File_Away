import javax.swing.*;
import java.io.*;

public class FileInspector {
    public static void main(String[] args) {

        // Open file chooser in the src directory of the IntelliJ project
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("src"));

        int result = chooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();

            System.out.println("===== FILE SELECTED: " + selectedFile.getName() + " =====\n");
            System.out.println("----- FILE CONTENTS -----");

            int lineCount = 0;
            int wordCount = 0;
            int charCount = 0;

            try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
                String line;

                while ((line = reader.readLine()) != null) {
                    System.out.println(line); // Echo line to the screen

                    lineCount++;

                    // Count words
                    if (!line.trim().isEmpty()) {
                        String[] words = line.trim().split("\\s+");
                        wordCount += words.length;
                    }

                    // Count characters in line
                    charCount += line.length();
                }

            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }

            // Summary Report
            System.out.println("\n----- SUMMARY REPORT -----");
            System.out.println("File Name: " + selectedFile.getName());
            System.out.println("Total Lines: " + lineCount);
            System.out.println("Total Words: " + wordCount);
            System.out.println("Total Characters: " + charCount);
        }
    }
}
