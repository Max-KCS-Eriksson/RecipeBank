package domain;

import datastorage.SerializeDataFileStorage;

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

    public void show(Recipe recipe) {}

    public void delete(Recipe recipe) {}

    public SerializeDataFileStorage getStorage() {
        return STORAGE;
    }
}
