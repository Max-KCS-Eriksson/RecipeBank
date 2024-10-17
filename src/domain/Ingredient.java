package domain;

import java.io.Serializable;

/** Ingredient */
public class Ingredient implements Serializable {

    private String name;
    private double quantity;
    private MeasurementUnit measurementUnit;

    public Ingredient() {
        super();
    }

    public Ingredient(String name, double quantity, MeasurementUnit measurementUnit) {
        setName(name);
        setQuantity(quantity);
        setMeasurementUnit(measurementUnit);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Ingredient name cannot be empty");
        }
        this.name = name.toLowerCase();
    }

    public double getQuantity() {
        return this.quantity;
    }

    public void setQuantity(double quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Ingredient quantity must be greatar than 0");
        }
        this.quantity = quantity;
    }

    public MeasurementUnit getMeasurementUnit() {
        return this.measurementUnit;
    }

    public void setMeasurementUnit(MeasurementUnit measurementUnit) {
        this.measurementUnit = measurementUnit;
    }

    @Override
    public String toString() {
        String nameInitial = this.name.substring(0, 1).toUpperCase();
        String name = nameInitial + this.name.substring(1);

        String formatedQuantity = String.format("%.2f", this.quantity);
        if (formatedQuantity.charAt(formatedQuantity.length() - 2) == '0') {
            formatedQuantity = String.format("%.0f", this.quantity);
        } else if (formatedQuantity.charAt(formatedQuantity.length() - 1) == '0') {
            formatedQuantity = String.format("%.1f", this.quantity);
        }
        return String.format("%s: %s %s", name, formatedQuantity, this.measurementUnit);
    }
}
