package domain;

import datastorage.SerializeDataFileStorage;

/** RecipeBank */
public class RecipeBank {

    private final SerializeDataFileStorage STORAGE;

    public RecipeBank(SerializeDataFileStorage storage) {
        STORAGE = storage;
    }

    public <T> void add(T object) {}

    public <T> void show(T object) {}

    public <T> void delete(T object) {}

    public SerializeDataFileStorage getStorage() {
        return STORAGE;
    }
}
