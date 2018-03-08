package business;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
<<<<<<< HEAD
import java.util.TreeMap;
=======
import java.util.Set;
>>>>>>> 49dd45180fea2fbd2e46dae85f5b518a193587f9

/**
 *
 * @author Søren Bendtsen
 */
<<<<<<< HEAD
public class RecipeManager
{
=======
public class RecipeManager {

    private Map<String, Recipe> recipeMap;
>>>>>>> 49dd45180fea2fbd2e46dae85f5b518a193587f9

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
