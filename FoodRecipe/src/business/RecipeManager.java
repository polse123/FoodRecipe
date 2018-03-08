package business;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Søren Bendtsen
 */
public class RecipeManager {
    private Map<String,Recipe> recipeMap;

    public RecipeManager() {
        this.recipeMap = new HashMap<>();
    }

    public Map getRecipeMap() {
        return recipeMap;
    }

}
