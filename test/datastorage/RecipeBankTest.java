package datastorage;

import domain.Ingredient;
import domain.MeasurementUnit;
import domain.Recipe;
import domain.RecipeCategory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecipeBankTest {

    private static File testFile;
    private static RecipeBank recipeBank;
    private static ArrayList<Recipe> recipes;
    private static Recipe dummyRecipe;
    private static Recipe anotherRecipe;

    @BeforeAll
    public static void setUp() {
        testFile = new File("test.txt");
        recipeBank = new RecipeBank(testFile);
        recipes = new ArrayList<>();

        ArrayList<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("ingredient", 1, MeasurementUnit.GRAMS));
        ArrayList<String> instructions = new ArrayList<>();
        instructions.add("instruction");
        dummyRecipe = new Recipe("foo", ingredients, instructions, RecipeCategory.PASTRY);
        anotherRecipe = new Recipe("bar", ingredients, instructions, RecipeCategory.DESSERT);
    }

    @AfterEach
    public void tearDown() {
        testFile.delete();
    }

    @BeforeEach
    public void resetUp() {
        recipes = new ArrayList<>(recipeBank.read());
    }

    @Test
    public void testAddNewRecipe() {
        int expectedSize = recipes.size() + 1;
        recipeBank.add(dummyRecipe);

        assertEquals(expectedSize, new ArrayList<Recipe>(recipeBank.read()).size());
    }

    @Test
    public void testDeleteRecipe() {
        recipeBank.add(dummyRecipe);
        recipeBank.add(anotherRecipe);
        int expectedSize = recipeBank.read().size() - 1;
        recipeBank.delete(dummyRecipe);
        int actualSize = recipeBank.read().size();

        assertEquals(expectedSize, actualSize);
    }
}
