package domain;

import java.io.Serializable;
import java.util.List;

/** Recipe */
public class Recipe implements Serializable {

    private String name;
    private List<Ingredient> ingredients;
    private List<String> instructions;

    public Recipe() {
        super();
    }

    public Recipe(String name, List<Ingredient> ingredients, List<String> instructions) {
        setName(name);
        setIngredients(ingredients);
        setInstructions(instructions);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Recipe name cannot be empty");
        }
        this.name = name.toLowerCase();
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<String> instructions) {
        this.instructions = instructions;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(name.substring(0, 1).toUpperCase() + name.substring(1) + "\n");
        builder.append("\n");
        builder.append("Ingredients\n");
        for (Ingredient ingredient : ingredients) {
            builder.append(ingredient.toString() + "\n");
        }
        builder.append("\n");
        builder.append("Instructions\n");
        for (int i = 0; i < instructions.size(); i++) {
            builder.append((i + 1) + ") " + instructions.get(i));
            if (i != instructions.size() - 1) {
                builder.append("\n");
            }
        }
        return builder.toString();
    }
}
