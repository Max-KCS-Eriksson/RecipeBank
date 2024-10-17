package ui;

import java.util.Scanner;

/** TUI */
public class TUI {

    private boolean isRunning;
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        System.out.println("Welcome to the Recipe Bank!\n");

        isRunning = true;
        do {
            System.out.println(
                    """
            What would you like to do with recipes?
            1)\tAdd
            2)\tShow
            3)\tDelete
            0)\tExit the Recipe Bank
            """);
            System.out.print("Choice > ");
            int menuChoice = Integer.parseInt(scanner.nextLine());
            switch (menuChoice) {
                case 1 -> add();
                case 2 -> show();
                case 3 -> delete();
                case 0 -> isRunning = false;
                default -> System.out.println("Invalid menu choice. Please try again.");
            }
        } while (isRunning);

        scanner.close();
        System.out.println("Enjoy your meal!");
    }

    private void add() {
        System.out.println("WARN: NOT IMPLEMENTED\n"); // TODO: IMPLEMENT
    }

    private void show() {
        System.out.println("WARN: NOT IMPLEMENTED\n"); // TODO: IMPLEMENT
    }

    private void delete() {
        System.out.println("WARN: NOT IMPLEMENTED\n"); // TODO: IMPLEMENT
    }
}
