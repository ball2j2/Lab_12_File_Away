import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataSaver {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> records = new ArrayList<>();

        System.out.println("=== DATA ENTRY ===");

        boolean keepGoing = true;
        while (keepGoing) {
            String firstName = SafeInput.getNonZeroLenString(in, "Enter First Name");
            String lastName = SafeInput.getNonZeroLenString(in, "Enter Last Name");

            int idNum = SafeInput.getInt(in, "Enter ID Number (integer)");
            String idFormatted = String.format("%06d", idNum);

            String email = SafeInput.getNonZeroLenString(in, "Enter Email");
            int yob = SafeInput.getRangedInt(in, "Enter Year of Birth", 1900, 2025);

            String record = firstName + ", " + lastName + ", " + idFormatted + ", " + email + ", " + yob;
            records.add(record);

            keepGoing = SafeInput.getYNConfirm(in, "Add another record?");
        }

        String fileName = SafeInput.getNonZeroLenString(in, "Enter file name to save (include .csv)");
        String filePath = "src/" + fileName;

        try (FileWriter writer = new FileWriter(filePath)) {
            for (String rec : records) {
                writer.write(rec + "\n");
            }
            System.out.println("File saved successfully: " + filePath);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}

