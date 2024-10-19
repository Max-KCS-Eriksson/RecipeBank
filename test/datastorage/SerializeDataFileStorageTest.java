package datastorage;

import domain.Ingredient;
import domain.MeasurementUnit;
import domain.Recipe;
import domain.RecipeCategory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class SerializeDataFileStorageTest {

    private static File file;
    private static SerializeDataFileStorage storage;

    private static ArrayList<Recipe> recipes;

    @BeforeAll
    public static void setUp() {
        file = new File("test.txt");
        storage = new SerializeDataFileStorage(file);

        recipes = new ArrayList<>();
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        ArrayList<String> instructions = new ArrayList<>();

        ingredients.add(new Ingredient("fizz", 1, MeasurementUnit.DECILITRES));
        ingredients.add(new Ingredient("buzz", 1, MeasurementUnit.DECILITRES));
        instructions.add("fizz");
        instructions.add("buzz");
        recipes.add(new Recipe("foo", ingredients, instructions, RecipeCategory.MEAL));

        ingredients.add(new Ingredient("fizzbuzz", 1, MeasurementUnit.PIECES));
        ingredients.add(new Ingredient("bar", 1, MeasurementUnit.GRAMS));
        instructions.add("fizzbuzz");
        recipes.add(new Recipe("bar", ingredients, instructions, RecipeCategory.DESSERT));
    }

    @AfterAll
    public static void tearDown() {
        file.delete();
    }

    @Test
    public void testFileCreation() {
        if (file.exists()) {
            file.delete();
        }
        storage.write(new ArrayList<String>());

        assertTrue(file.exists());
    }

    @Test
    public void testWriteRecipesToFile() throws IOException {
        assertDoesNotThrow(() -> storage.write(recipes));
    }

    @Test
    public void testReadRecipesFromFile() throws IOException {
        storage.write(recipes);
        ArrayList<Recipe> storedRecipes = new ArrayList<>(storage.read());

        for (int i = 0; i < recipes.size(); i++) {
            String actualTitle = storedRecipes.get(i).getName();
            String expectedTitle = recipes.get(i).getName();
            assertEquals(expectedTitle, actualTitle);
        }
        assertEquals(recipes.size(), storedRecipes.size());
    }
}
