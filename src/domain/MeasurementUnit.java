package domain;

/** MeasurementUnit */
public enum MeasurementUnit {
    DECILITRES("decilitres"),
    GRAMS("grams"),
    PIECES("pieces");

    public final String value;

    private MeasurementUnit(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
