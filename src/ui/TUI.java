package ui;

import ui.util.TUIInput;

/** TUI */
public class TUI {

    private boolean isRunning;
    private TUIInput scanner = new TUIInput();

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
            int menuChoice = scanner.inputInt("Choice");
            switch (menuChoice) {
                case 1 -> add();
                case 2 -> show();
                case 3 -> delete();
                case 0 -> isRunning = false;
                default -> System.out.println("Invalid menu choice. Please try again.\n");
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
