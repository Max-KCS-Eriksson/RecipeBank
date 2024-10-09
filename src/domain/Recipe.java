package domain;

import java.util.List;

/** Recipe */
public class Recipe {

    private String title;
    private List<Ingredient> ingredients;
    private List<String> instructions;

    public Recipe(String title, List<Ingredient> ingredients, List<String> instructions) {
        if (title.isBlank()) {
            throw new IllegalArgumentException("Recipe title cannot be empty");
        }
        this.title = title.toLowerCase();
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    public String getTitle() {
        return title;
    }
}
