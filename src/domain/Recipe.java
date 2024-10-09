package domain;

import java.util.List;

/** Recipe */
public class Recipe {

    private String title;
    private List<Ingredient> ingredients;
    private List<String> instructions;

    public Recipe(String title, List<Ingredient> ingredients, List<String> instructions) {
        this.title = title;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    public String getTitle() {
        return title;
    }
}
