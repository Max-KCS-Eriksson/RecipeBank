package datastorage;

import domain.Recipe;

import java.io.File;
import java.util.ArrayList;

/** RecipeBank */
public class RecipeBank extends SerializeDataFileStorage {

    public RecipeBank(final File FILE) {
        super(FILE);
    }

    public RecipeBank(final String FILE_NAME) {
        this(new File(FILE_NAME));
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
            if (!recipe.getName().equals(target.getName())
                    || recipe.getName().equals(target.getName())
                            && !recipe.getCategory().equals(target.getCategory())) {
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
