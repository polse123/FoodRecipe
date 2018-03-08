package business;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;
import java.util.Set;

/**
 *
 * @author Søren Bendtsen
 */
public class RecipeManager
{

    private Map<String, Recipe> recipeMap;

    public RecipeManager()
    {
        this.recipeMap = new TreeMap<>();
    }

    public Map getRecipeMap()
    {
        return recipeMap;
    }

    public void saveRecipe(Recipe r) {
        recipeMap.put(r.getName(), r);
    }

    public Set<Recipe> toSet() {
        Set<Recipe> set = new HashSet<Recipe>();
        for (Map.Entry<String, Recipe> entry : recipeMap.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
    
    public void printRecipes() {
        for (Map.Entry<String, Recipe> entry : recipeMap.entrySet()) {
            System.out.println(entry.getKey() + "\t" + entry.getValue().getName() + "\t" + entry.getValue().getProcedure());
        }
    }
}
