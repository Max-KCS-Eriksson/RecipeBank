import datastorage.RecipeBank;

import ui.TUI;

public class Main {
    public static void main(String[] args) {
        RecipeBank recipeBank = new RecipeBank("RecipeBank.ser");
        TUI ui = new TUI(recipeBank);
        ui.run();
    }
}
