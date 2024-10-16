package datastorage;

import domain.Recipe;

import java.io.File;
import java.util.ArrayList;

/** RecipeBank */
public class RecipeBank extends SerializeDataFileStorage {

    public RecipeBank(final File FILE) {
        super(FILE);
    }

    public void add(Recipe recipe) {
        ArrayList<Recipe> recipes = this.getStorage();
        recipes.add(recipe);
        this.write(recipes);
    }

    public void delete(Recipe target) {
        ArrayList<Recipe> recipes = this.getStorage();

        ArrayList<Recipe> tempArr = new ArrayList<>();
        for (Recipe recipe : recipes) {
            if (!recipe.getTitle().equals(target.getTitle())) {
                tempArr.add(recipe);
            }
        }
        recipes = tempArr;

        this.write(recipes);
    }

    public ArrayList<Recipe> getStorage() {
        return new ArrayList<>(this.read());
    }
}
