package domain;

import java.util.List;

/** ShoppingList */
public class ShoppingList {

    private List<Ingredient> ingredients;

    public ShoppingList(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Shopping List\n");
        for (int i = 0; i < ingredients.size(); i++) {
            builder.append((i + 1) + ")\t" + ingredients.get(i));
            if (i != ingredients.size() - 1) {
                builder.append("\n");
            }
        }
        return builder.toString();
    }
}
