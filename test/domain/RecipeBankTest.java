package domain;

import datastorage.SerializeDataFileStorage;
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

    @BeforeAll
    public static void setUp() {
        testFile = new File("test.txt");
        recipeBank = new RecipeBank(new SerializeDataFileStorage(testFile));
        recipes = new ArrayList<>();

        ArrayList<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("ingredient", 1, MeasurementUnit.GRAMS));
        ArrayList<String> instructions = new ArrayList<>();
        instructions.add("instruction");
        dummyRecipe = new Recipe("foo", ingredients, instructions);
    }

    @AfterEach
    public void tearDown() {
        testFile.delete();
    }

    @BeforeEach
    public void resetUp() {
        recipes = new ArrayList<>(recipeBank.getStorage().read());
    }

    @Test
    public void testAddNewRecipe() {
        int expectedSize = recipes.size() + 1;
        recipeBank.add(dummyRecipe);

        assertEquals(expectedSize, new ArrayList<Recipe>(recipeBank.getStorage().read()).size());
    }

    @Test
    public void testDeleteRecipe() {
        recipeBank.add(dummyRecipe);
        int expectedSize = recipes.size() - 1;
        recipeBank.delete(dummyRecipe);
        int actualSize = recipeBank.getStorage().read().size();

        assertEquals(expectedSize, actualSize);
    }
}
