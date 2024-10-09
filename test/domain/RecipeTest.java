package domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RecipeTest {

    @Test
    public void testTitleIsAlwaysLowerCase() {
        String title = "Always LowerCase";

        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("demo", 1, MeasurementUnit.DECILITRES));
        List<String> instructions = new ArrayList<>();
        instructions.add("First");

        Recipe ingredient = new Recipe(title, ingredients, instructions);

        assertEquals(title.toLowerCase(), ingredient.getTitle());
    }

    @Test
    public void testTitleCannotBeEmpty() {
        String title = "";

        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("demo", 1, MeasurementUnit.DECILITRES));
        List<String> instructions = new ArrayList<>();
        instructions.add("First");

        assertThrows(
                IllegalArgumentException.class, () -> new Recipe(title, ingredients, instructions));
    }

    @Test
    public void testTitleCannotBeBlankCharsOnly() {
        String title = " ";

        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("demo", 1, MeasurementUnit.DECILITRES));
        List<String> instructions = new ArrayList<>();
        instructions.add("First");

        assertThrows(
                IllegalArgumentException.class, () -> new Recipe(title, ingredients, instructions));
    }
}
