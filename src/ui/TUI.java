package ui;

import datastorage.RecipeBank;

import domain.Ingredient;
import domain.MeasurementUnit;
import domain.Recipe;
import domain.RecipeCategory;
import domain.ShoppingList;

import ui.util.TUIInput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/** TUI */
public class TUI {

    private boolean isRunning;
    private TUIInput scanner = new TUIInput();
    private RecipeBank recipeBank;

    private RecipeCategory[] recipeCategories = {
        RecipeCategory.MEAL, RecipeCategory.DESSERT, RecipeCategory.PASTRY
    };

    public TUI(RecipeBank recipeBank) {
        this.recipeBank = recipeBank;
    }

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
        Recipe recipe = new Recipe();
        System.out.println("\nRecipe");

        boolean validInput = false;
        while (!validInput) {
            try {
                recipe.setName(scanner.inputString("Title"));
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + ". Try again.");
            }
        }

        System.out.println("\nCategory from below list:");
        printRecipeCategories();
        recipe.setCategory(selectFromList(recipeCategories));

        ArrayList<Ingredient> ingredients = new ArrayList<>();
        int minimumIngredients = 2;
        while (ingredients.size() < minimumIngredients) {
            ingredients.add(addIngredient());
        }
        boolean addIngredients = true;
        while (addIngredients) {
            String input = scanner.inputString("\nMore ingredients? (y/n)");
            if (input.equals("y") || input.equals("yes")) {
                ingredients.add(addIngredient());
            } else if (input.equals("n") || input.equals("no")) {
                addIngredients = false;
            }
        }
        recipe.setIngredients(ingredients);

        System.out.println("\nInstructions");
        ArrayList<String> instructions = new ArrayList<>();
        int minimumInstructions = 2;
        int i;
        for (i = 0; i < minimumInstructions; i++) {
            String inputPrompt = (i + 1) + " ";
            instructions.add(addInstruction(inputPrompt));
        }
        boolean addInstructions = true;
        while (addInstructions) {
            String input = scanner.inputString("\nMore instructions? (y/n)");
            if (input.equals("y") || input.equals("yes")) {
                String inputPrompt = (i + 1) + " ";
                instructions.add(addInstruction(inputPrompt));
                i++;
            } else if (input.equals("n") || input.equals("no")) {
                addInstructions = false;
            }
        }
        recipe.setInstructions(instructions);

        recipeBank.add(recipe);
    }

    private Ingredient addIngredient() {
        Ingredient ingredient = new Ingredient();
        System.out.println("\nIngredient");

        boolean validInput = false;
        while (!validInput) {
            try {
                ingredient.setName(scanner.inputString("Name"));
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + ". Try again.");
            }
        }

        validInput = false;
        while (!validInput) {
            try {
                ingredient.setQuantity(scanner.inputDouble("Quantity"));
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + ". Try again.");
            }
        }

        MeasurementUnit[] measurementUnits = {
            MeasurementUnit.DECILITRES, MeasurementUnit.GRAMS, MeasurementUnit.PIECES,
        };
        boolean validChoice = false;
        do {
            System.out.println("Measurement unit from below list:");
            for (int i = 0; i < measurementUnits.length; i++) {
                System.out.println(
                        (i + 1) + ")\t" + toInitialUpperCase(measurementUnits[i].toString()));
            }
            int choice = scanner.inputInt("Choice");
            if (choice - 1 < measurementUnits.length) {
                ingredient.setMeasurementUnit(measurementUnits[choice - 1]);
                validChoice = true;
            } else {
                System.out.println("Invalid choice. Please try again.\n");
            }
        } while (!validChoice);

        return ingredient;
    }

    private String addInstruction(String inputPrompt) {
        String instruction;
        boolean valid = false;
        do {
            instruction = scanner.inputString(inputPrompt);
            valid = !instruction.isBlank();
            if (!valid) {
                System.out.println("Instruction can't be blank. Please Try again.");
            }
        } while (!valid);
        return instruction;
    }

    private void show() {
        List<Recipe> recipes = recipesByCategory();

        Optional<Recipe> optional = selectRecipeFromStorage(recipes);
        Recipe recipe;
        try {
            recipe = optional.get();
        } catch (NoSuchElementException e) {
            return;
        }

        System.out.printf(
                "\nWhat would you like to do with the %s recipe?\n",
                toInitialUpperCase(recipe.getName()));
        String[] choices = {"Show the full recipe", "List all ingredients"};
        for (int i = 0; i < choices.length; i++) {
            System.out.println((i + 1) + ") " + choices[i]);
        }
        System.out.println(); // Output format

        Object outputObject = null;
        while (outputObject == null) {
            int choice = pickListIndex(choices);
            switch (choice + 1) {
                case 1 -> outputObject = recipe;
                case 2 -> outputObject = new ShoppingList(recipe.getIngredients());
            }
        }
        System.out.println("\n" + outputObject + "\n");
    }

    private void delete() {
        List<Recipe> recipes = recipesByCategory();

        Optional<Recipe> optional = selectRecipeFromStorage(recipes);
        Recipe recipe;
        try {
            recipe = optional.get();
        } catch (NoSuchElementException e) {
            return;
        }

        recipeBank.delete(recipe);
        System.out.println("\n" + toInitialUpperCase(recipe.getName()) + " Recipe was deleted.\n");
    }

    private Optional<Recipe> selectRecipeFromStorage(List<Recipe> recipes) {
        System.out.println("\nRecipes:");
        if (recipes.size() == 0) {
            System.out.println("No recipes stored yet.\n");
            return Optional.empty();
        }
        for (int i = 0; i < recipes.size(); i++) {
            String name = toInitialUpperCase(recipes.get(i).getName());
            System.out.println((i + 1) + ")\t" + name);
        }

        System.out.println("\nSelect recipe from above list.");
        Recipe recipe = selectFromList(recipes);

        return Optional.of(recipe);
    }

    private void printRecipeCategories() {
        for (int i = 0; i < recipeCategories.length; i++) {
            System.out.println(
                    (i + 1) + ")\t" + toInitialUpperCase(recipeCategories[i].toString()));
        }
    }

    private List<Recipe> recipesByCategory() {
        System.out.println("\nCategories:");
        printRecipeCategories();
        System.out.println(); // Output format

        RecipeCategory category = selectFromList(recipeCategories);
        List<Recipe> byCategory = new ArrayList<>();
        List<Recipe> recipes = recipeBank.getStorage();
        for (Recipe recipe : recipes) {
            if (recipe.getCategory().equals(category)) {
                byCategory.add(recipe);
            }
        }
        return byCategory;
    }

    private <T> int pickListIndex(T[] arr) {
        return pickListIndex(Arrays.asList(arr));
    }

    private <T> int pickListIndex(List<T> list) {
        while (true) {
            int index = scanner.inputInt("Choice") - 1;
            if (index >= 0 && index < list.size()) {
                return index;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private <T> T selectFromList(T[] arr) {
        return selectFromList(Arrays.asList(arr));
    }

    private <T> T selectFromList(List<T> list) {
        while (true) {
            try {
                return list.get(scanner.inputInt("Choice") - 1);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private String toInitialUpperCase(String string) {
        return string.substring(0, 1).toUpperCase() + string.substring(1);
    }
}
