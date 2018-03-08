package main;

import acq.*;
import business.*;
import data.DataFacade;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Søren Bendtsen
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code applicastiteston logic here
        // frederikstest
        // nikolajstest
        RecipeManager rM = new RecipeManager();
        IBusiness business = new BusinessFacade();
        DataFacade dF = new DataFacade();
        HashSet<String> ing = new HashSet<>();
        HashSet<String> ing2 = new HashSet<>();

        // save
        ing.add("oksekød");
        ing.add("ost");
        ing2.add("chokolade");
        ing2.add("smør");
        rM.saveRecipe(new Recipe("lagsagne", RecipeType.MAIN_COURSE, 90, "mix it all up", ing));
        rM.saveRecipe(new Recipe("Cookie", RecipeType.SNACK, 60, "mix it all up", ing2));
        dF.saveRecipes(rM.toSet());
        //*/

        // load
        /*
        Map<String, String> loadedData = dF.load();
        int count = 0;
        for (Map.Entry<String, String> entry : loadedData.entrySet()) {
            Map<String, String> map = DataString.toMap(entry.getValue());
            Recipe r = new Recipe(map);
            rM.saveRecipe(r);
        }
        rM.printRecipes();
        //*/
    }

}
