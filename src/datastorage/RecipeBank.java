package datastorage;

import domain.Recipe;

import java.util.ArrayList;

/** RecipeBank */
public class RecipeBank {

    private final SerializeDataFileStorage STORAGE;

    public RecipeBank(SerializeDataFileStorage storage) {
        STORAGE = storage;
    }

    public void add(Recipe recipe) {
        ArrayList<Recipe> recipes = new ArrayList<>(STORAGE.read());
        recipes.add(recipe);
        STORAGE.write(recipes);
    }

    public void delete(Recipe target) {
        ArrayList<Recipe> recipes = new ArrayList<>(STORAGE.read());

        ArrayList<Recipe> tempArr = new ArrayList<>();
        for (Recipe recipe : recipes) {
            if (!recipe.getTitle().equals(target.getTitle())) {
                tempArr.add(recipe);
            }
        }
        recipes = tempArr;

        STORAGE.write(recipes);
    }

    public SerializeDataFileStorage getStorage() {
        return STORAGE;
    }
}
