package domain;

/** RecipeCategory */
public enum RecipeCategory {
    MEAL("meal"),
    DESSERT("dessert"),
    PASTRY("pastry");

    public final String value;

    private RecipeCategory(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
