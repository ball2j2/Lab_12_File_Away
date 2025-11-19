import java.util.Scanner;

public class SafeInput {

    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String ret = "";
        do {
            System.out.print(prompt + ": ");
            ret = pipe.nextLine();
        } while (ret.trim().isEmpty());
        return ret;
    }

    public static int getInt(Scanner pipe, String prompt) {
        int ret = 0;
        boolean done = false;
        do {
            System.out.print(prompt + ": ");
            if (pipe.hasNextInt()) {
                ret = pipe.nextInt();
                pipe.nextLine();
                done = true;
            } else {
                System.out.println("Invalid integer. Try again.");
                pipe.nextLine();
            }
        } while (!done);
        return ret;
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int ret = 0;
        boolean done = false;
        do {
            System.out.print(prompt + " (" + low + "-" + high + "): ");
            if (pipe.hasNextInt()) {
                ret = pipe.nextInt();
                pipe.nextLine();
                if (ret >= low && ret <= high)
                    done = true;
                else
                    System.out.println("OUT OF RANGE!");
            } else {
                System.out.println("Invalid input.");
                pipe.nextLine();
            }
        } while (!done);
        return ret;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String response;
        do {
            System.out.print(prompt + " [Y/N]: ");
            response = pipe.nextLine().trim().toUpperCase();
        } while (!response.equals("Y") && !response.equals("N"));

        return response.equals("Y");
    }
}

