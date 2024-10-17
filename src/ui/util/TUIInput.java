package ui.util;

import java.util.Scanner;

/** TUIInput */
public class TUIInput {

    private final Scanner SCANNER;

    public TUIInput() {
        SCANNER = new Scanner(System.in);
    }

    public String inputString(String prompt) {
        System.out.print(prompt + " > ");
        return SCANNER.nextLine();
    }

    public int inputInt(String prompt) {
        while (true) {
            try {
                return Integer.parseInt(inputString(prompt));
            } catch (NumberFormatException e) {
                System.out.println("Invalid input - only accept integers. Try again.");
            }
        }
    }

    public double inputDouble(String prompt) {
        while (true) {
            try {
                return Double.parseDouble(inputString(prompt));
            } catch (NumberFormatException e) {
                System.out.println("Invalid input - only accept numerics. Try again.");
            }
        }
    }

    public void close() {
        SCANNER.close();
    }
}
