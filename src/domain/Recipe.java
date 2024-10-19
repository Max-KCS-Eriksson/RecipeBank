package domain;

import java.util.List;

/** Recipe */
public class Recipe extends NamedObject {

    private List<Ingredient> ingredients;
    private List<String> instructions;
    private RecipeCategory category;

    public Recipe() {
        super();
    }

    public Recipe(
            String name,
            List<Ingredient> ingredients,
            List<String> instructions,
            RecipeCategory category) {
        setName(name);
        setIngredients(ingredients);
        setInstructions(instructions);
        setCategory(category);
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

    public RecipeCategory getCategory() {
        return category;
    }

    public void setCategory(RecipeCategory category) {
        this.category = category;
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
