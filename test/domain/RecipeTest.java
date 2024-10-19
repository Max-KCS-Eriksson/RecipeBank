package domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RecipeTest {

    @Test
    public void testTitleIsAlwaysLowerCase() {
        String title = "Always LowerCase";

        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("demo", 1, MeasurementUnit.DECILITRES));
        List<String> instructions = new ArrayList<>();
        instructions.add("First");

        Recipe ingredient = new Recipe(title, ingredients, instructions, RecipeCategory.DESSERT);

        assertEquals(title.toLowerCase(), ingredient.getName());
    }

    @Test
    public void testTitleCannotBeEmpty() {
        String title = "";

        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("demo", 1, MeasurementUnit.DECILITRES));
        List<String> instructions = new ArrayList<>();
        instructions.add("First");

        assertThrows(
                IllegalArgumentException.class, () -> new Recipe(title, ingredients, instructions, RecipeCategory.DESSERT));
    }

    @Test
    public void testTitleCannotBeBlankCharsOnly() {
        String title = " ";

        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("demo", 1, MeasurementUnit.DECILITRES));
        List<String> instructions = new ArrayList<>();
        instructions.add("First");

        assertThrows(
                IllegalArgumentException.class, () -> new Recipe(title, ingredients, instructions, RecipeCategory.DESSERT));
    }

    @Test
    public void testToString() {
        String expected = """
                Pancakes

                Ingredients
                Milk: 5.5 decilitres
                Egg: 3 pieces
                Wheat flour: 2.25 decilitres
                Salt: 2 grams

                Instructions
                1) Mix dry ingredients.
                2) Mix in half of the milk.
                3) Mix in the eggs and the rest of the milk.
                4) Pour batter into hot pan and fry on both sides.""";

        String title = "paNcakes";
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("milk", 5.5, MeasurementUnit.DECILITRES));
        ingredients.add(new Ingredient("egg", 3, MeasurementUnit.PIECES));
        ingredients.add(new Ingredient("wheat flour", 2.25, MeasurementUnit.DECILITRES));
        ingredients.add(new Ingredient("salt", 2, MeasurementUnit.GRAMS));
        List<String> instructions = new ArrayList<>();
        instructions.add("Mix dry ingredients.");
        instructions.add("Mix in half of the milk.");
        instructions.add("Mix in the eggs and the rest of the milk.");
        instructions.add("Pour batter into hot pan and fry on both sides.");
        Recipe recipe = new Recipe(title, ingredients, instructions, RecipeCategory.MEAL);

        assertEquals(expected, recipe.toString());
    }
}
