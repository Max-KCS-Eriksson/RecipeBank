package domain;

import datastorage.SerializeDataFileStorage;

/** RecipeBank */
public class RecipeBank {

    private final SerializeDataFileStorage STORAGE;

    public RecipeBank(SerializeDataFileStorage storage) {
        STORAGE = storage;
    }

    public void add(Recipe recipe) {}

    public void show(Recipe recipe) {}

    public void delete(Recipe recipe) {}

    public SerializeDataFileStorage getStorage() {
        return STORAGE;
    }
}
