package domain;

/** Ingredient */
public class Ingredient {

    private String name;
    private double quantity;
    private MeasurementUnit measurementUnit;

    public Ingredient(String name, double quantity, MeasurementUnit measurementUnit) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Ingredient name cannot be empty");
        }
        this.name = name.toLowerCase();
        this.quantity = quantity;
        this.measurementUnit = measurementUnit;
    }

    public String getName() {
        return this.name;
    }

    public double getQuantity() {
        return this.quantity;
    }

    public MeasurementUnit getMeasurementUnit() {
        return this.measurementUnit;
    }
}
