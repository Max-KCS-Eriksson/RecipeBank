package domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class IngredientTest {

    @Test
    public void testNameIsAlwaysLowerCase() {
        String name = "Always LowerCase";
        Ingredient ingredient = new Ingredient(name, 0.1, MeasurementUnit.DECILITRES);

        assertEquals(name.toLowerCase(), ingredient.getName());
    }

    @Test
    public void testNameCannotBeEmpty() {
        String name = "";
        assertThrows(
                IllegalArgumentException.class,
                () -> new Ingredient(name, 0.1, MeasurementUnit.DECILITRES));
    }

    @Test
    public void testNameCannotBeBlankCharsOnly() {
        String name = " ";
        assertThrows(
                IllegalArgumentException.class,
                () -> new Ingredient(name, 0.1, MeasurementUnit.DECILITRES));
    }

    @Test
    public void testQuantityCannotBeZero() {
        double quantity = 0;
        assertThrows(
                IllegalArgumentException.class,
                () -> new Ingredient("Cream", quantity, MeasurementUnit.DECILITRES));
    }

    @Test
    public void testQuantityCannotBeNegative() {
        double quantity = -1.0;
        assertThrows(
                IllegalArgumentException.class,
                () -> new Ingredient("Cream", quantity, MeasurementUnit.DECILITRES));
    }
}
