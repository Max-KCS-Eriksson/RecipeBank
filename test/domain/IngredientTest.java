package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    public void testToStringWithRoundedToTwoDigits() {
        Ingredient ingredient = new Ingredient("caROT", 2.251111, MeasurementUnit.PIECES);
        String expected = "Carot: 2.25 pieces";

        assertEquals(expected, ingredient.toString());
    }

    @Test
    public void testToStringWithSingleDigit() {
        Ingredient ingredient = new Ingredient("MILK", 2.5, MeasurementUnit.DECILITRES);
        String expected = "Milk: 2.5 decilitres";

        assertEquals(expected, ingredient.toString());
    }
}
