package domain;

import java.io.Serializable;
import java.util.List;

/** Recipe */
public class Recipe implements Serializable {

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

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public List<String> getInstructions() {
        return instructions;
    }
}
